package gft.PartidoConsumerAPI.controllers;

import gft.PartidoConsumerAPI.service.PartidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping
    public ResponseEntity<List<?>> listarTodosOsPartidos(@RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(partidoService.buscarTodosOsPartidos(token));
    }

    @GetMapping("{sigla}")
    public ResponseEntity<Object> buscarPartidoPorSigla(@PathVariable String sigla,
                                                      @RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(partidoService.buscarPartidoPorSigla(sigla,token));
    }

    private String getBearerTokenValue(String authorization){
        String token = authorization.substring(7, authorization.length());
        return token;
    }
}
