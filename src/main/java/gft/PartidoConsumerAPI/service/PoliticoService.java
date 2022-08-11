package gft.PartidoConsumerAPI.service;

import gft.PartidoConsumerAPI.entities.RestPageImpl;
import gft.PartidoConsumerAPI.exception.RequestErrorException;
import gft.PartidoConsumerAPI.exception.RestTemplateResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PoliticoService {

    private RestTemplate restTemplate;

    public PoliticoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    public Object buscarPoliticoPorId(String cargo, Long id, String token){
        String url = "http://localhost:8081/v1/"+ cargo +"/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ParameterizedTypeReference<Object> responseType = new ParameterizedTypeReference<Object>() { };

        ResponseEntity<Object> result = restTemplate.exchange(url, HttpMethod.GET, request, responseType);
        return result.getBody();
    }

    public List<?> buscarTodosOsPoliticos(String token){
        String url = "http://localhost:8081/v1/politicos";
        return enviarRequestPage(url, token);
    }

    public List<?> buscarTodosOsPoliticosAsc(String token){
        String url = "http://localhost:8081/v1/politicos/asc";
        return enviarRequestPage(url, token);
    }

    public List<?> buscarTodosOsPoliticosDesc(String token){
        String url = "http://localhost:8081/v1/politicos/desc";
        return enviarRequestPage(url, token);
    }

    public List<?> buscarTodosOsPoliticosPorNumeroDeProjetos(Integer numeroProjetos, String token){
        String url = "http://localhost:8081/v1/politicos/"+numeroProjetos;
        return enviarRequestPage(url, token);
    }

    public List<?> buscarTodosOsPoliticosPorCargo(String cargo, String token){

        String url = "http://localhost:8081/v1/"+ cargo;
        return enviarRequestPage(url, token);
    }

    public List<?> buscarTodosOsPoliticosPorCargoAsc(String cargo, String token){

        String url = "http://localhost:8081/v1/"+ cargo +"?sort=nome,asc";
        return enviarRequestPage(url, token);
    }

    public List<?> buscarTodosOsPoliticosPorCargoDesc(String cargo, String token){
        String url = "http://localhost:8081/v1/"+ cargo +"?sort=nome,desc";
        return enviarRequestPage(url, token);
    }

    private List<?> enviarRequestPage(String url, String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ParameterizedTypeReference<RestPageImpl<?>> responseType = new ParameterizedTypeReference<RestPageImpl<?>>() { };

        ResponseEntity<RestPageImpl<?>> result = restTemplate.exchange(url, HttpMethod.GET, request, responseType);
        return result.getBody().getContent();

    }

}
