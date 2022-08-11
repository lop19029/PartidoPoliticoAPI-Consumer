package gft.PartidoConsumerAPI.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends PartidoConsumerAPIException{
    public EntityNotFoundException(String message, HttpStatus statusCode) {
        super(message, statusCode);
    }
}
