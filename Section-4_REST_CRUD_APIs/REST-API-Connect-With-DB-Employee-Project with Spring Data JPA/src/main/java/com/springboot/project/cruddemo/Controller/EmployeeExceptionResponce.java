package com.springboot.project.cruddemo.Controller;

public class EmployeeExceptionResponce {
    private int statusCode;
    private String message;
    private long timeStamp;

    public EmployeeExceptionResponce(int statusCode, String message, long timeStamp){
        this.statusCode=statusCode;
        this.message=message;
        this.timeStamp=timeStamp;
    }


    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

}

