package gft.PartidoConsumerAPI.service;

import gft.PartidoConsumerAPI.entities.RestPageImpl;
import gft.PartidoConsumerAPI.exception.RequestErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PartidoService {

    public Object buscarPartidoPorSigla(String sigla, String token){
        String url = "http://localhost:8081/v1/partidos/"+ sigla;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ParameterizedTypeReference<Object> responseType = new ParameterizedTypeReference<Object>() { };
        try {
            ResponseEntity<Object> result = restTemplate.exchange(url, HttpMethod.GET, request, responseType);
            return result.getBody();
        } catch (HttpClientErrorException e){
            throw new RequestErrorException(e.getMessage(),e.getStatusCode());
        }
    }

    public List<?> buscarTodosOsPartidos(String token){

        String url = "http://localhost:8081/v1/partidos";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ParameterizedTypeReference<RestPageImpl<?>> responseType = new ParameterizedTypeReference<RestPageImpl<?>>() { };

        try {
            ResponseEntity<RestPageImpl<?>> result = restTemplate.exchange(url, HttpMethod.GET, request, responseType);
            return result.getBody().getContent();
        } catch (HttpClientErrorException e) {
            throw new RequestErrorException(e.getMessage(), e.getStatusCode());
        }
    }


}
