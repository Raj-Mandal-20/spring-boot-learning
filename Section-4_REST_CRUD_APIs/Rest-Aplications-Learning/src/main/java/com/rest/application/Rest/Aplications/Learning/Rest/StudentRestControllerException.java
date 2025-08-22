package com.rest.application.Rest.Aplications.Learning.Rest;


import com.rest.application.Rest.Aplications.Learning.Entity.CustomException;
import com.rest.application.Rest.Aplications.Learning.Entity.StudentNotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class StudentRestControllerException {
    @ExceptionHandler
    public ResponseEntity<StudentNotFoundResponse> handleException(CustomException except){
        long timeStamp =  new Date().getTime();
        StudentNotFoundResponse error = new StudentNotFoundResponse(except.getStatusCode(), except.getMessage(), timeStamp);

        if(except.getStatusCode() == 400) return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<StudentNotFoundResponse> otherExceptions(Exception exc){
        long timeStamp =  new Date().getTime();
        StudentNotFoundResponse error = new StudentNotFoundResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), timeStamp);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
