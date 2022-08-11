package gft.PartidoConsumerAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class PartidoConsumerAPIException extends HttpClientErrorException {
    private String message;
    private HttpStatus statusCode;

    public PartidoConsumerAPIException(String message, HttpStatus statusCode) {
        super(statusCode);
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getStatusCode() {
        return this.statusCode;
    }

    public void setMessage(String message){this.message = message;}
}
