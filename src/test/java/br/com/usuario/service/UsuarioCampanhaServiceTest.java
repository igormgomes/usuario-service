package br.com.usuario.service;

import br.com.usuario.client.CampanhaClient;
import br.com.usuario.domain.model.Usuario;
import br.com.usuario.domain.service.UsuarioCampanhaService;
import br.com.usuario.domain.service.impl.UsuarioCampanhaServiceImpl;
import br.com.usuario.response.CampanhaResponse;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Teste do service de usuario campanha")
public class UsuarioCampanhaServiceTest {

    private CampanhaClient campanhaClient;
    private UsuarioCampanhaService usuarioCampanhaService;

    @BeforeEach
    public void beforeEach() {
        this.campanhaClient = mock(CampanhaClient.class);
        this.usuarioCampanhaService = new UsuarioCampanhaServiceImpl(this.campanhaClient);
    }

    @Test
    @DisplayName("Testa que é a busca de campanhas é efetuada")
    public void testaQueABuscaDeCampanhasEhOk() {
        CampanhaResponse campanhaResponse = new CampanhaResponse();
        campanhaResponse.setId(1L);

        when(this.campanhaClient.busca(anyLong()))
                .thenReturn( Lists.newArrayList(campanhaResponse));

        List<CampanhaResponse> campanhas = this.usuarioCampanhaService.getCampanhas(new Usuario());

        assertEquals(1, campanhas.size());
        assertEquals((Long) 1L, campanhas.get(0).getId());
    }
}