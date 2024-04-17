package tech.ada.java.todolist.item;

import java.util.List;
import java.util.UUID;
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
import tech.ada.java.todolist.NaoEncontradoException;

@RestController
@RequestMapping("/todo-itens")
public class TodoItemController {

    private final TodoItemRepository repository;

    public TodoItemController(TodoItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TodoItem> listar() {
        return this.repository.findAll();
    }

    @GetMapping(value = "consultar", params = "titulo")
    public List<TodoItem> consultarPorTitulo(@RequestParam String titulo) {
        return this.repository.findByTituloContainingIgnoreCase(titulo);
    }

    @GetMapping("/{uuid}")
    public TodoItem buscarPorUuid(@PathVariable UUID uuid) {
        return this.repository.findByUuid(uuid)
            .orElseThrow(NaoEncontradoException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody TodoItem item) {
        this.repository.save(item);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable UUID uuid, @RequestBody TodoItem itemAtualizado) {
        TodoItem todoItem = this.buscarPorUuid(uuid);
        itemAtualizado.setId(todoItem.getId());
        this.adicionar(itemAtualizado);
    }


    @PatchMapping("/{uuid}/concluir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void marcarComoConcluido(@PathVariable UUID uuid) {
        this.repository.marcarConcluido(uuid);
    }

    @DeleteMapping("/{uuid}")
    public void excluir(@PathVariable UUID uuid) {
        this.repository.delete(this.buscarPorUuid(uuid));
    }

}
