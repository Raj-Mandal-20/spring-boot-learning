package com.springboot.project.cruddemo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalEmployeeException {

    @ExceptionHandler
    ResponseEntity<EmployeeExceptionResponce> handleException(EmployeeException exc){
        long timeStamp = new Date().getTime();
        EmployeeExceptionResponce error = new EmployeeExceptionResponce(404, exc.getMessage(), timeStamp);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<EmployeeExceptionResponce> edgeCases(Exception exc){
        long timeStamp = new Date().getTime();
        EmployeeExceptionResponce error = new EmployeeExceptionResponce(400, exc.getMessage(), timeStamp);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
