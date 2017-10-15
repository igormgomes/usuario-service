package br.com.usuario.config;

import br.com.usuario.handler.CustomResponseErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomResponseErrorHandler customResponseErrorHandler;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .errorHandler(this.customResponseErrorHandler)
                .messageConverters(new MappingJackson2HttpMessageConverter(this.objectMapper))
                .build();
    }
}
