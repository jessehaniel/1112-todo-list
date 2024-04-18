package tech.ada.java.todolist.item;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tech.ada.java.todolist.NaoEncontradoException;
import tech.ada.java.todolist.usuario.UsuarioRepository;

@RestController
@RequestMapping("/todo-itens")
@RequiredArgsConstructor
public class TodoItemController {

    private final TodoItemRepository repository;
    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<TodoItemDto> listar() {
        return this.repository.findAll().stream()
            .map(TodoItem::toDto).toList();
    }

    @GetMapping(value = "consultar", params = "titulo")
    public List<TodoItemDto> consultarPorTitulo(@RequestParam String titulo) {
        return this.repository.findByTituloContainingIgnoreCase(titulo).stream()
            .map(TodoItem::toDto).toList();
    }

    @GetMapping("/{uuid}")
    public TodoItemDto buscarPorUuid(@PathVariable UUID uuid) {
        return this.repository.findByUuid(uuid)
            .map(TodoItem::toDto)
            .orElseThrow(NaoEncontradoException::new);
    }

    @GetMapping("/usuarios/{username}")
    public List<TodoItemDto> buscarPorUsuario(@PathVariable String username) {
        return this.repository.findByUsuarioUsername(username).stream()
            .map(TodoItem::toDto).toList();
    }

    @PostMapping("/usuarios/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemDto adicionar(@PathVariable String username, @RequestBody TodoItemRequest request) {
        TodoItem item = TodoItem.fromRequest(request);
        setUserForItem(username, item);
        return this.repository.save(item).toDto();
    }

    private void setUserForItem(String username, TodoItem item) {
        item.setUsuario(this.usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado")));
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable UUID uuid, @RequestBody TodoItemUpdateRequest request) {
        TodoItem todoItem = this.repository.findByUuid(uuid).orElseThrow(NaoEncontradoException::new);
        TodoItem itemAtualizado = TodoItem.fromUpdateRequest(request, todoItem.getId(), todoItem.getUsuario());
        this.repository.save(itemAtualizado).toDto();
    }

    @PatchMapping("/{uuid}/concluido")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void marcarComoConcluido(@PathVariable UUID uuid) {
        this.repository.marcarConcluido(uuid);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void excluir(@PathVariable UUID uuid) {
        this.repository.deleteByUuid(uuid);
    }

}
