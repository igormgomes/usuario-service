package br.com.usuario.service;

import br.com.usuario.builder.UsuarioDataBuilder;
import br.com.usuario.domain.model.Usuario;
import br.com.usuario.domain.repository.UsuarioRepository;
import br.com.usuario.domain.service.UsuarioService;
import br.com.usuario.domain.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Teste do service de usuario")
public class UsuarioServiceTest {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @BeforeEach
    public void beforeEach() {
        this.usuarioRepository = mock(UsuarioRepository.class);
        this.usuarioService = new UsuarioServiceImpl(this.usuarioRepository);
    }

    @Test
    @DisplayName("Testa que é retornado um usuário com id")
    public void testaQueEhRetornadoUmUsuarioComId() {
        Usuario usuarioBuilder = UsuarioDataBuilder.builder()
                .id(1L)
                .build();
        when(this.usuarioRepository.findByEmail(anyString()))
                .thenReturn(usuarioBuilder);

        Usuario usuario = this.usuarioService.salva(new Usuario());

        assertThat(usuario.getId(), is(equalTo(1L)));
    }
}
