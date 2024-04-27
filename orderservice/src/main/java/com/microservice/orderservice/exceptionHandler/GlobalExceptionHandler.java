package com.microservice.orderservice.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(NoSuchElementException.class)
   public ResponseEntity<ExceptionResponse> handleNoSuchElementException(Exception ex){


      ExceptionResponse response= new ExceptionResponse(ex.getClass().getSimpleName(),HttpStatus.NOT_FOUND.toString(), UUID.randomUUID().toString());
       return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
