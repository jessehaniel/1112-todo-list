package tech.ada.java.todolist;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException() {
        super("Não foi possível encontrar");
    }
}
