package br.com.usuario.request;

import java.util.List;

public class CampanhaUsuarioRequest {

    private List<Long> idsCampanha;

    private Long idUsuario;

    public List<Long> getIdsCampanha() {
        return idsCampanha;
    }

    public void setIdsCampanha(List<Long> idsCampanha) {
        this.idsCampanha = idsCampanha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
