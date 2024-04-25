package tech.ada.java.todolist.item;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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

@RestController
@RequestMapping("/todo-itens")
@RequiredArgsConstructor
public class TodoItemController {

    private final TodoItemService service;

    @GetMapping
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Usuario.Role).ADMIN.name())")
    public List<TodoItemDto> listar() {
        return this.service.listar();
    }

    @GetMapping("/pageable")
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Usuario.Role).ADMIN.name())")
    public Page<TodoItemDto> listar(Pageable pageable) {
        return this.service.listar(pageable);
    }

    @GetMapping(value = "consultar", params = "titulo")
    public List<TodoItemDto> consultarPorTitulo(@RequestParam String titulo) {
        return this.service.consultarPorTitulo(titulo);
    }

    @GetMapping("/{uuid}")
    public TodoItemDto buscarPorUuid(@PathVariable UUID uuid) {
        return this.service.buscarPorUuid(uuid);
    }

    @GetMapping("/usuarios/{username}")
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Usuario.Role).CLIENTE.name())")
    public List<TodoItemDto> buscarPorUsuario(@PathVariable String username, Authentication authentication) {
        if (!authentication.getName().equals(username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        return this.service.buscarPorUsuario(username);
    }

    @PostMapping("/usuarios/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Usuario.Role).CLIENTE.name())")
    public TodoItemDto adicionar(@PathVariable String username, @RequestBody TodoItemRequest request, Authentication authentication) {
        if (!authentication.getName().equals(username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        return this.service.adicionar(username, request);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable UUID uuid, @RequestBody TodoItemUpdateRequest request) {
        this.service.atualizar(uuid, request);
    }

    @PatchMapping("/{uuid}/concluido")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Usuario.Role).CLIENTE.name())")
    public void marcarComoConcluido(@PathVariable UUID uuid, Authentication authentication) {
        this.service.marcarConcluido(uuid);
    }

    @DeleteMapping("/{uuid}")
    public void excluir(@PathVariable UUID uuid) {
        this.service.excluir(uuid);
    }

}
