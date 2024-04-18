package tech.ada.java.todolist.usuario;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.ada.java.todolist.usuario.Usuario.Role;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDto implements Serializable {

    private String email;
    private String username;
    private String password;
    private Role role;
    private boolean active;

}