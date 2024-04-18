package tech.ada.java.todolist.exception;

public class UsuarioNaoEncontradoException extends NaoEncontradoException {

    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado");
    }
}
