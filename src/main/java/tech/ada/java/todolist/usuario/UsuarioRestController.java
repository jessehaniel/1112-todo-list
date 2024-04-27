package tech.ada.java.todolist.usuario;

import static tech.ada.java.todolist.security.PermissionValitation.validatePermission;

import jakarta.validation.Valid;
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
    public UsuarioDto buscarPorUsername(@PathVariable String username, Authentication authentication) {
        if (validatePermission.apply(authentication, username)) {
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
    public void excluir(@PathVariable String username, Authentication authentication) {
        if (validatePermission.apply(authentication, username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        this.service.excluir(username);
    }

}
