package gft.PartidoConsumerAPI.exception;

import org.springframework.http.HttpStatus;

public class RequestErrorException extends PartidoConsumerAPIException{
    public RequestErrorException(String message, HttpStatus statusCode) {
        super(message, statusCode);
    }
}
