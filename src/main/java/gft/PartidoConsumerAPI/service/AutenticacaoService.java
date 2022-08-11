package gft.PartidoConsumerAPI.service;

import gft.PartidoConsumerAPI.dto.auth.AutenticacaoDTO;
import gft.PartidoConsumerAPI.dto.auth.TokenDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AutenticacaoService {

    private final WebClient webClient;

    public AutenticacaoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public TokenDTO autenticarUsuario(AutenticacaoDTO dto){
        Mono<TokenDTO> tokenDTOMono = this.webClient
                .post()
                .uri("/v1/auth")
                .body(BodyInserters.fromValue(dto))
                .retrieve()
                .bodyToMono(TokenDTO.class);

        return tokenDTOMono.block();
    }

}
