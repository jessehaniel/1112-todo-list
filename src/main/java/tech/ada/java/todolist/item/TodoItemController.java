package tech.ada.java.todolist.item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoItemController {

    private final List<TodoItem> todoItemList = new ArrayList<>();

    public TodoItemController() {
        this.todoItemList.addAll(List.of(
            new TodoItem("Tarefa aula 1", "Completar nossa API", LocalDateTime.of(2023, 10, 15, 19, 0)),
            new TodoItem("Ler um livro - técnico", "Ler o livro Código Limpo", LocalDateTime.of(2023, 10, 31, 19, 0)),
            new TodoItem("Ler um livro - cotidiano", "O poder do hábito", LocalDateTime.of(2023, 10, 31, 19, 0)),
            new TodoItem("Ver um filme", "Matrix", LocalDateTime.of(2023, 10, 17, 22, 0)),
            new TodoItem("Ver um filme", "A Origem", LocalDateTime.of(2023, 10, 25, 19, 0)),
            new TodoItem("Finalizar o projeto do projeto", "Nosso projeto de netflix", LocalDateTime.of(2023, 10, 18, 19, 0)),
            new TodoItem("Ir ao café", "Tomar um cafezinho e apreciar a rua", LocalDateTime.of(2023, 10, 18, 9, 0)),
            new TodoItem("Dar uma volta", "Andar pela cidade como um turista", LocalDateTime.of(2023, 10, 19, 10, 0)),
            new TodoItem("Levar o cachorro pra passear", "Viva os doguinhos!", LocalDateTime.of(2023, 10, 16, 10, 0)),
            new TodoItem("Pizza e cerveja", "Completar nossa API", LocalDateTime.of(2023, 10, 18, 19, 0))
        ));
    }

    //1. Criar
    //2. Listar
    //3. Consultar
    //4. Acessar/Detalhar
    //5. Atualizar
    //6. Marcar como concluído
    //7. Excluir

    public List<TodoItem> listar() {
        return this.todoItemList;
    }


}
