package org.example.response;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class GeneralResponse {
    private Date timestamp;
    private int customStatusCode;
    private String error;
    private String path;
    private HttpStatus statusCode;

    private String message;

    public GeneralResponse(Date timestamp, int customStatusCode, String error, String path, String message) {
        this.timestamp = timestamp;
        this.customStatusCode = customStatusCode;
        this.error = error;
        this.path = path;
        this.message = message;
    }

    public GeneralResponse(Date timestamp, HttpStatus statusCode, String message) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.message = message;
    }

    public GeneralResponse(Date timestamp, int customStatusCode, String message) {
        this.timestamp = timestamp;
        this.customStatusCode = customStatusCode;
        this.message = message;
    }

    public GeneralResponse() {
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public int getCustomStatusCode() {
        return customStatusCode;
    }

    public void setCustomStatusCode(int customStatusCode) {
        this.customStatusCode = customStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
