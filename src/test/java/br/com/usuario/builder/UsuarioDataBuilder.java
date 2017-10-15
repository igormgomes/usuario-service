package br.com.usuario.builder;

import br.com.usuario.domain.model.Usuario;

public class UsuarioDataBuilder {

    private Long id;
    private Long idTime;

    public static UsuarioDataBuilder builder () {
        return new UsuarioDataBuilder();
    }

    public UsuarioDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioDataBuilder idTime(Long idTime) {
        this.idTime = idTime;
        return this;
    }

    public Usuario build () {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setIdTimeDoCoracao(this.idTime);
        return usuario;
    }
}