package br.com.usuario.mapper;

import br.com.usuario.domain.model.Usuario;
import br.com.usuario.request.UsuarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioRequestMapper {

    @Mappings(value = {
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "dataDeNascimento", target = "dataDeNascimento"),
            @Mapping(source = "idTimeDoCoracao", target = "idTimeDoCoracao")
    })
    Usuario parse(UsuarioRequest usuarioRequest);
}
