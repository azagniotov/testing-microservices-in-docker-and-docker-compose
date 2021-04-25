package io.github.azagniotov.example.controller;

public class WebServiceException extends RuntimeException {

    private final String message;

    public WebServiceException(final String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
