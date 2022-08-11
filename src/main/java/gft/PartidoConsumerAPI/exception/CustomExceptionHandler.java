package gft.PartidoConsumerAPI.exception;

import gft.PartidoConsumerAPI.dto.APIErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ RequestErrorException.class })
    public ResponseEntity<APIErrorDTO> handleRequestErrorException(RequestErrorException exception){
        String error = "Não foi possivel completar a requisição.";

        APIErrorDTO apiErrorDTO = new APIErrorDTO(exception.getMessage(), error, exception.getStatusCode());

        return new ResponseEntity<APIErrorDTO>(apiErrorDTO, new HttpHeaders(), apiErrorDTO.getStatus());

    }
    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<APIErrorDTO> handleEntityNotFoundException(EntityNotFoundException exception){
        String error = "Entidade não encontrada no servidor.";

        APIErrorDTO apiErrorDTO = new APIErrorDTO(exception.getMessage(), error, exception.getStatusCode());

        return new ResponseEntity<APIErrorDTO>(apiErrorDTO, new HttpHeaders(), apiErrorDTO.getStatus());

    }
    @ExceptionHandler({ ServerErrorException.class })
    public ResponseEntity<APIErrorDTO> handleServerErrorException(ServerErrorException exception){
        String error = "Erro no servidor.";

        APIErrorDTO apiErrorDTO = new APIErrorDTO(exception.getMessage(), error, exception.getStatusCode());

        return new ResponseEntity<APIErrorDTO>(apiErrorDTO, new HttpHeaders(), apiErrorDTO.getStatus());

    }
}
