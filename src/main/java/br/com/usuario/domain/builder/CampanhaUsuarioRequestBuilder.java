package br.com.usuario.domain.builder;

import br.com.usuario.request.CampanhaUsuarioRequest;

import java.util.List;

public class CampanhaUsuarioRequestBuilder {

    private List<Long> ids;
    private Long idUsuario;

    public static CampanhaUsuarioRequestBuilder builder () {
        return new CampanhaUsuarioRequestBuilder();
    }

    public CampanhaUsuarioRequestBuilder idsCampanhas(List<Long> idsCampanhas) {
        this.ids = idsCampanhas;
        return this;
    }

    public CampanhaUsuarioRequestBuilder idUsuario (Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public CampanhaUsuarioRequest build () {
        CampanhaUsuarioRequest campanhaUsuarioRequest = new CampanhaUsuarioRequest();
        campanhaUsuarioRequest.setIdsCampanha(this.ids);
        campanhaUsuarioRequest.setIdUsuario(this.idUsuario);
        return campanhaUsuarioRequest;
    }
}
