package br.com.usuario.domain.service;

import br.com.usuario.domain.model.Usuario;
import br.com.usuario.response.CampanhaResponse;

import java.util.List;

public interface UsuarioCampanhaService {

    List<CampanhaResponse> getCampanhas(Usuario usuario);
}
