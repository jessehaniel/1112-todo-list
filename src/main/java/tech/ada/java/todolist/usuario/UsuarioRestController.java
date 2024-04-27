package tech.ada.java.todolist.usuario;

import jakarta.validation.Valid;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final UsuarioService service;

    @GetMapping
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Usuario.Role).ADMIN.name())")
    public List<UsuarioDto> listarTodos() {
        return this.service.listarTodos();
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAnyRole(T(tech.ada.java.todolist.usuario.Usuario.Role).CLIENTE.name(),T(tech.ada.java.todolist.usuario.Usuario.Role).ADMIN.name())")
    public UsuarioDto buscarPorUsername(@PathVariable String username, Principal principal) {
        if (!principal.getName().equals(username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        return this.service.buscarPorUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto adicionarUsuario(@Valid @RequestBody UsuarioRequest usuario) {
        return this.service.adicionarUsuario(usuario);
    }

    @DeleteMapping("/{username}")
    @PreAuthorize("hasAnyRole(T(tech.ada.java.todolist.usuario.Usuario.Role).CLIENTE.name(),T(tech.ada.java.todolist.usuario.Usuario.Role).ADMIN.name())")
    public void excluir(@PathVariable String username, Authentication authentication) {
        if (!authentication.getName().equals(username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        this.service.excluir(username);
    }

}
