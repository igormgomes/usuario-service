package br.com.usuario.client;

import br.com.usuario.request.CampanhaUsuarioRequest;
import br.com.usuario.response.CampanhaResponse;

import java.util.List;

public interface CampanhaClient {

    List<CampanhaResponse> busca (Long idTimeCoracao);

    void associa (CampanhaUsuarioRequest campanhaUsuarioRequest);
}
