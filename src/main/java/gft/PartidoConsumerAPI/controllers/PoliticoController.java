package gft.PartidoConsumerAPI.controllers;

import gft.PartidoConsumerAPI.service.PoliticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/politicos")
public class PoliticoController {

    private final PoliticoService politicoService;

    public PoliticoController(PoliticoService politicoService) {
        this.politicoService = politicoService;
    }

    @GetMapping("all")
    public ResponseEntity<List<?>> listarTodosOsPoliticos(@RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarTodosOsPoliticos(token));
    }

    @GetMapping("all/asc")
    public ResponseEntity<List<?>> listarTodosOsPoliticosAsc(@RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarTodosOsPoliticosAsc(token));
    }

    @GetMapping("all/desc")
    public ResponseEntity<List<?>> listarTodosOsPoliticosDesc(@RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarTodosOsPoliticosDesc(token));
    }

    @GetMapping("{cargo}")
    public ResponseEntity<List<?>> listarTodosOsPoliticosPorCargo(@PathVariable String cargo,
                                                                     @RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarTodosOsPoliticosPorCargo(cargo, token));
    }

    @GetMapping("{cargo}/asc")
    public ResponseEntity<List<?>> listarTodosOsPoliticosPorCargoAsc(@PathVariable String cargo,
                                                                                    @RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarTodosOsPoliticosPorCargoAsc(cargo, token));
    }

    @GetMapping("{cargo}/desc")
    public ResponseEntity<List<?>> listarTodosOsPoliticosPorCargoDesc(@PathVariable String cargo,
                                                                  @RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarTodosOsPoliticosPorCargoDesc(cargo, token));
    }

    @GetMapping("projetos/{numeroProjetos}")
    public ResponseEntity<List<?>> listarTodosOsPoliticosPorNumeroDeProjetos(@PathVariable Integer numeroProjetos,
                                                                      @RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarTodosOsPoliticosPorNumeroDeProjetos(numeroProjetos, token));
    }

    @GetMapping("{cargo}/{id}")
    public ResponseEntity<Object> buscarPoliticoPorId(@PathVariable String cargo,
                                                      @PathVariable Long id,
                                                      @RequestHeader String Authorization){
        String token = getBearerTokenValue(Authorization);
        return ResponseEntity.ok(politicoService.buscarPoliticoPorId(cargo, id,token));
    }

    private String getBearerTokenValue(String authorization){
        String token = authorization.substring(7, authorization.length());
        return token;
    }
}
