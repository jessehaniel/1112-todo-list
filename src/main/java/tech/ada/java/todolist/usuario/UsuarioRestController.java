package tech.ada.java.todolist.usuario;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.java.todolist.NaoEncontradoException;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final UsuarioRepository repository;

    @GetMapping
    public List<UsuarioDto> listarTodos() {
        return this.repository.findAll().stream()
            .map(Usuario::toDto).toList();
    }

    @GetMapping("/{username}")
    public UsuarioDto buscarPorUsername(@PathVariable String username) {
        return this.repository.findByUsername(username)
            .map(Usuario::toDto)
            .orElseThrow(NaoEncontradoException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto adicionarUsuario(@RequestBody Usuario usuario) {
        return this.repository.save(usuario).toDto();
    }

    @Transactional
    @DeleteMapping("/{username}")
    public void excluir(@PathVariable String username) {
        this.repository.deleteByUsername(username);
    }

}
