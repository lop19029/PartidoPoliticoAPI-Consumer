package gft.PartidoConsumerAPI.controllers;

import gft.PartidoConsumerAPI.dto.auth.AutenticacaoDTO;
import gft.PartidoConsumerAPI.dto.auth.TokenDTO;
import gft.PartidoConsumerAPI.service.AutenticacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> autenticarUsuario (@RequestBody AutenticacaoDTO autenticacaoDTO){

        try {
            return ResponseEntity.ok(autenticacaoService.autenticarUsuario(autenticacaoDTO));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
