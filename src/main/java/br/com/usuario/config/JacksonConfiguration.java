package br.com.usuario.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatterBuilder;

@Configuration
public class JacksonConfiguration {

    @Autowired
    private Jackson2ObjectMapperBuilder builder;

    @PostConstruct
    @Bean
    @Primary
    public ObjectMapper postConstruct () {
        return this.builder
                .serializers(new LocalDateSerializer(new DateTimeFormatterBuilder()
                        .appendPattern("dd/MM/yyyy").toFormatter()))
                .deserializers(new LocalDateDeserializer(new DateTimeFormatterBuilder()
                        .appendPattern("dd/MM/yyyy").toFormatter()))
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .build();
    }
}
