package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PROCESSING)
public class GenericException extends Exception{
//    private HttpStatus statusCode;
    private String message;

    public GenericException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GenericException{" +
                "message='" + message + '\'' +
                '}';
    }
}
