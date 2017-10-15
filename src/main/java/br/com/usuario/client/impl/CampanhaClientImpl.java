package br.com.usuario.client.impl;

import br.com.usuario.client.CampanhaClient;
import br.com.usuario.exception.CampanhaNotFoundException;
import br.com.usuario.request.CampanhaUsuarioRequest;
import br.com.usuario.response.CampanhaResponse;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@Component
public class CampanhaClientImpl implements CampanhaClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${campanha.url}")
    private String url;

    private RestTemplate restTemplate;

    @Autowired
    public CampanhaClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "campanhaDefault", ignoreExceptions = {HttpClientErrorException.class, CampanhaNotFoundException.class})
    @Override
    public List<CampanhaResponse> busca (Long idTimeCoracao) {
        URI uri = URI.create(url + "/campanha/time/" + idTimeCoracao);
        this.logger.info(uri.getPath());
        this.logger.info(uri.getHost());

        ResponseEntity<CampanhaResponse[]> responseEntity = this.restTemplate.getForEntity(uri, CampanhaResponse[].class);
        this.logger.info(String.format("%d", responseEntity.getStatusCodeValue()));

        return Lists.newArrayList(responseEntity.getBody());
    }

    @HystrixCommand(fallbackMethod = "associaDefault", ignoreExceptions = {HttpClientErrorException.class})
    @Override
    public void associa (CampanhaUsuarioRequest campanhaUsuarioRequest) {
        URI uri = URI.create(url + "/campanha/associa");
        this.logger.info(uri.getPath());
        this.logger.info(uri.getHost());

        ResponseEntity<Object> responseEntity = this.restTemplate.postForEntity(uri, campanhaUsuarioRequest, Object.class);
        this.logger.info(String.format("%d", responseEntity.getStatusCodeValue()));
    }

    public List<CampanhaResponse> campanhaDefault(Long idTimeCoracao) {
        CampanhaResponse campanhaResponse = new CampanhaResponse();
        campanhaResponse.setDataInicioVigencia(LocalDate.now());
        campanhaResponse.setDataFimVigencia(LocalDate.now().plusDays(1));
        campanhaResponse.setNome("Campanha default");
        campanhaResponse.setIdTimeDoCoracao(idTimeCoracao);
        return Lists.newArrayList(campanhaResponse);
    }

    public void associaDefault(CampanhaUsuarioRequest campanhaUsuarioRequest) {
    }
}
