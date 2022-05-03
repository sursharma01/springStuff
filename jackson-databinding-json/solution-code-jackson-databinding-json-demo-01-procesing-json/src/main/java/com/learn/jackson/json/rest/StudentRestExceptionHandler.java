package com.learn.jackson.json.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> errorHandler(StudentNotFoundException studentNotFoundException){
        StudentErrorResponse studentError = new StudentErrorResponse();
        studentError.setStatus(HttpStatus.NOT_FOUND.value());
        studentError.setMessage(studentNotFoundException.getMessage());
        studentError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentError, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> genericErrorHandler(Exception exception){
        StudentErrorResponse studentError = new StudentErrorResponse();
        studentError.setStatus(HttpStatus.BAD_REQUEST.value());
        studentError.setMessage("studentId should be Int type");
        studentError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentError, HttpStatus.BAD_REQUEST);
    }
}
