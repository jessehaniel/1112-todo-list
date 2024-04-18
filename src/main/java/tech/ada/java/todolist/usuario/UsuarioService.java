package tech.ada.java.todolist.usuario;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.ada.java.todolist.exception.UsuarioNaoEncontradoException;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public List<UsuarioDto> listarTodos() {
        return this.repository.findAll().stream()
            .map(usuario -> this.modelMapper.map(usuario, UsuarioDto.class))
            .toList();
    }

    public UsuarioDto buscarPorUsername(String username) {
        Usuario usuario = this.repository.findByUsername(username)
            .orElseThrow(UsuarioNaoEncontradoException::new);
        return this.modelMapper.map(usuario, UsuarioDto.class);
    }

    public UsuarioDto adicionarUsuario(UsuarioRequest request) {
        Usuario usuario = modelMapper.map(request, Usuario.class);
        Usuario novoUsuario = repository.save(usuario);
        return modelMapper.map(novoUsuario, UsuarioDto.class);
    }

    @Transactional
    public void excluir(String username) {
        this.repository.deleteByUsername(username);
    }
}
