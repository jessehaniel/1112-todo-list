package tech.ada.java.todolist.item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private final List<TodoItem> todoItemList = new ArrayList<>();

    public TodoItemController() {
        this.todoItemList.addAll(List.of(
            new TodoItem("Tarefa aula 1", "Completar nossa API", LocalDateTime.of(2024, 4, 15, 22, 0)),
            new TodoItem("Ler um livro - técnico", "Ler o livro Código Limpo", LocalDateTime.of(2024, 4, 30, 19, 0)),
            new TodoItem("Ler um livro - cotidiano", "O poder do hábito", LocalDateTime.of(2024, 4, 30, 19, 0)),
            new TodoItem("Ver um filme", "Matrix", LocalDateTime.of(2024, 4, 20, 22, 0)),
            new TodoItem("Ver um filme", "A Origem", LocalDateTime.of(2024, 4, 25, 23, 0)),
            new TodoItem("Finalizar o projeto do projeto", "Nosso projeto", LocalDateTime.of(2024, 4, 17, 19, 0)),
            new TodoItem("Ir ao café", "Tomar um cafezinho e apreciar a rua", LocalDateTime.of(2024, 4, 16, 9, 0)),
            new TodoItem("Dar uma volta", "Andar pela cidade como um turista", LocalDateTime.of(2024, 4, 19, 10, 0)),
            new TodoItem("Levar o cachorro pra passear", "Viva os doguinhos!", LocalDateTime.of(2024, 4, 16, 10, 0)),
            new TodoItem("Pizza e cerveja", "Completar nossa API", LocalDateTime.of(2024, 4, 26, 19, 0))
        ));
    }

    @GetMapping
    public List<TodoItem> listar() {
        return this.todoItemList;
    }

    @GetMapping(value = "consultar", params = "titulo")
    public List<TodoItem> consultarPorTitulo(@RequestParam String titulo) {
        return this.todoItemList.stream()
            .filter(it -> it.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
            .toList();
    }

    @GetMapping("/{uuid}")
    public TodoItem buscarPorUuid(@PathVariable UUID uuid) {
        return buscarPorUuidOptional(uuid)
            .orElseThrow(NaoEncontradoException::new);
    }

    private Optional<TodoItem> buscarPorUuidOptional(UUID uuid) {
        return this.todoItemList.stream()
            .filter(it -> it.getUuid().equals(uuid))
            .findFirst();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem adicionar(@RequestBody TodoItem item) {
        this.todoItemList.add(item);
        return item;
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable UUID uuid, @RequestBody TodoItem itemAtualizado) {
        int index = this.buscarIndicePorUuid(uuid);
        if (index == -1) {
            throw new NaoEncontradoException();
        }
        this.todoItemList.set(index, itemAtualizado);
    }

    private int buscarIndicePorUuid(UUID uuid) {
        for (int i = 0; i < this.todoItemList.size(); i++) {
            if (this.todoItemList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @PatchMapping("/{uuid}/concluido")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void marcarComoConcluido(@PathVariable UUID uuid) {
        TodoItem item = buscarPorUuid(uuid);
        item.setConcluido(true);
    }

    @DeleteMapping("/{uuid}")
    public void excluir(@PathVariable UUID uuid) {
        TodoItem item = buscarPorUuid(uuid);
        this.todoItemList.remove(item);
    }

}
