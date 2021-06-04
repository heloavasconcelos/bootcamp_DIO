package com.project.Bootcamp.exceptions;

public class ExceptionsResponse {

    private String message;

    public ExceptionsResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
