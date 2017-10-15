package br.com.usuario.domain.service.impl;

import br.com.usuario.client.CampanhaClient;
import br.com.usuario.domain.builder.CampanhaUsuarioRequestBuilder;
import br.com.usuario.domain.model.Usuario;
import br.com.usuario.domain.service.UsuarioCampanhaService;
import br.com.usuario.request.CampanhaUsuarioRequest;
import br.com.usuario.response.CampanhaResponse;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCampanhaServiceImpl implements UsuarioCampanhaService {

    private CampanhaClient campanhaClient;

    @Autowired
    public UsuarioCampanhaServiceImpl(CampanhaClient campanhaClient) {
        this.campanhaClient = campanhaClient;
    }

    @Override
    public List<CampanhaResponse> getCampanhas (Usuario  usuario) {
        List<CampanhaResponse> campanhasResponse = this.campanhaClient.busca(usuario.getIdTimeDoCoracao());
        List<Long> idsCampanhas = Lists.newArrayList();
        campanhasResponse.forEach(campanhaResponse -> idsCampanhas.add(campanhaResponse.getId()));
        CampanhaUsuarioRequest campanhaUsuarioRequest = CampanhaUsuarioRequestBuilder.builder()
                .idsCampanhas(idsCampanhas)
                .idUsuario(usuario.getId())
                .build();
        this.campanhaClient.associa(campanhaUsuarioRequest);
        return campanhasResponse;
    }
}