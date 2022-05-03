package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> errorHandler(CustomerNotFoundException customerNotFoundException){
        CustomerErrorResponse studentError = new CustomerErrorResponse();
        studentError.setStatus(HttpStatus.NOT_FOUND.value());
        studentError.setMessage(customerNotFoundException.getMessage());
        studentError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentError, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> genericErrorHandler(Exception exception){
        CustomerErrorResponse studentError = new CustomerErrorResponse();
        studentError.setStatus(HttpStatus.BAD_REQUEST.value());
        studentError.setMessage("studentId should be Int type");
        studentError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentError, HttpStatus.BAD_REQUEST);
    }
}
