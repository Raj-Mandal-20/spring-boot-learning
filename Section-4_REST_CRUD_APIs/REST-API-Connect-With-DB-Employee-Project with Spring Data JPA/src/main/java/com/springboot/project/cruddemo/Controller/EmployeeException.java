package com.springboot.project.cruddemo.Controller;

public class EmployeeException extends RuntimeException {
    public EmployeeException(String message){
        super(message);
    }
}
