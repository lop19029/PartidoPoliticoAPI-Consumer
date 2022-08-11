package gft.PartidoConsumerAPI.exception;

import org.springframework.http.HttpStatus;

public class ServerErrorException extends PartidoConsumerAPIException{
    public ServerErrorException(String message, HttpStatus statusCode) {
        super(message, statusCode);
    }
}
