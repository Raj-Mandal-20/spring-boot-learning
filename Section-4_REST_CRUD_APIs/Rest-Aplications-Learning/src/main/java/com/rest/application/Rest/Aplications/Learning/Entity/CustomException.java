package com.rest.application.Rest.Aplications.Learning.Entity;

public class CustomException extends RuntimeException {
    private int statusCode;
    public CustomException(String message,int statusCode){
        super(message);
        this.statusCode = statusCode;

    }
    public int getStatusCode(){
        return this.statusCode;
    }
}
