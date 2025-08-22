package com.rest.application.Rest.Aplications.Learning.Entity;


public class StudentNotFoundResponse {
    private int statusCode;
    private long timeStamp;
    private String message;

    public StudentNotFoundResponse(int statusCode, String message, long timeStamp){
         this.message = message;
         this.statusCode = statusCode;
         this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getMessage(){
    return this.message;
    }
}
