package br.com.usuario.handler;

import br.com.usuario.exception.CampanhaNotFoundException;
import br.com.usuario.response.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CustomResponseErrorHandler implements ResponseErrorHandler {

    private ResponseErrorHandler errorHandler;
    private ObjectMapper objectMapper;

    @Autowired
    public CustomResponseErrorHandler(ObjectMapper objectMapper) {
        this.errorHandler = new DefaultResponseErrorHandler();
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return errorHandler.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        InputStream inputStream = response.getBody();
        ErrorMessage errorMessage = this.objectMapper.readValue(inputStream, ErrorMessage.class);
        throw new CampanhaNotFoundException(errorMessage);
    }
}
