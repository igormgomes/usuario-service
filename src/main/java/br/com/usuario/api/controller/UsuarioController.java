package br.com.usuario.api.controller;

import br.com.usuario.api.UsuarioResource;
import br.com.usuario.domain.model.Usuario;
import br.com.usuario.domain.service.UsuarioCampanhaService;
import br.com.usuario.domain.service.UsuarioService;
import br.com.usuario.mapper.UsuarioRequestMapper;
import br.com.usuario.request.UsuarioRequest;
import br.com.usuario.response.CampanhaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController implements UsuarioResource {

    private UsuarioService usuarioService;
    private UsuarioCampanhaService usuarioCampanhaService;
    private UsuarioRequestMapper usuarioRequestMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioCampanhaService usuarioCampanhaService,
                             UsuarioRequestMapper usuarioRequestMapper) {
        this.usuarioService = usuarioService;
        this.usuarioCampanhaService = usuarioCampanhaService;
        this.usuarioRequestMapper = usuarioRequestMapper;
    }

    @Override
    public ResponseEntity salva(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = this.usuarioService.salva(this.usuarioRequestMapper.parse(usuarioRequest));
        List<CampanhaResponse> campanhas = this.usuarioCampanhaService.getCampanhas(usuario);
        return ResponseEntity.created(URI.create("/usuario/" + usuario.getId())).body(campanhas);
    }
}
