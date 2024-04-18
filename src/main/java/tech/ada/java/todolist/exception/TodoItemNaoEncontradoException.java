package tech.ada.java.todolist.exception;

public class TodoItemNaoEncontradoException extends NaoEncontradoException {

    public TodoItemNaoEncontradoException() {
        super("To-do Item não encontrado");
    }
}
