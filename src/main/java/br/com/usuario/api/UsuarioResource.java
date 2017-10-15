package br.com.usuario.api;

import br.com.usuario.request.UsuarioRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@Api(tags = "Usuário")
public interface UsuarioResource {

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Salva um usuário e faz a associação com as campanhas")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity salva (UsuarioRequest usuarioRequest);
}
