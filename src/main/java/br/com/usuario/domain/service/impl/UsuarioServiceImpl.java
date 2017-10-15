package br.com.usuario.domain.service.impl;

import br.com.usuario.domain.model.Usuario;
import br.com.usuario.domain.repository.UsuarioRepository;
import br.com.usuario.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salva(Usuario usuario) {
        Optional<Usuario> usuarioOptional = Optional.ofNullable(this.usuarioRepository.findByEmail(usuario.getEmail()));
        usuarioOptional.ifPresent(u -> {
            usuario.setId(u.getId());
            this.usuarioRepository.save(usuario);
        });
        usuarioOptional.orElseGet(() -> this.usuarioRepository.save(usuario));
        return usuario;
    }
}