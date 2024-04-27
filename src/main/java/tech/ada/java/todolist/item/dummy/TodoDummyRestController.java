package tech.ada.java.todolist.item.dummy;

import static tech.ada.java.todolist.security.PermissionValitation.validatePermission;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tech.ada.java.todolist.client.Todo;
import tech.ada.java.todolist.client.TodoRestRepository;
import tech.ada.java.todolist.item.TodoItemDto;
import tech.ada.java.todolist.item.TodoItemRequest;
import tech.ada.java.todolist.item.TodoItemService;

@RestController
@RequestMapping("/todo-itens")
@RequiredArgsConstructor
public class TodoDummyRestController {

    private final TodoItemService service;
    private final TodoRestRepository todoRestRepository;

    @PostMapping("/carregar-dummy")
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Usuario.Role).ADMIN.name())")
    public Boolean carregarFromDummy() {
        List<Todo> dummyList = this.todoRestRepository.getAll(10L).todos();
        dummyList.stream()
            .map(this::converterTodoEmTodoItem)
            .forEach(this.service::adicionar);
        return true;
    }

    private TodoItemRequest converterTodoEmTodoItem(Todo todo) {
        TodoItemRequest todoItem = new TodoItemRequest();
        todoItem.setTitulo(todo.todo());
        todoItem.setDetalhes(todo.todo());
        return todoItem;
    }

    @PatchMapping("/{uuid}/atribuir-usuario/{username}")
    public TodoItemDto atribuirUsuario(@PathVariable UUID uuid, @PathVariable String username, Authentication authentication) {
        if (validatePermission.apply(authentication, username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        return this.service.atribuirUsuario(uuid, username);
    }
}
