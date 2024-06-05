package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.PersonNameNullException;

@ControllerAdvice
public class PersonControlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNameNullException.class)
    public ResponseEntity<Object> captureErrorNull(){
        
        Map<String, Object> body = new HashMap<String, Object>();

        body.put("Message", "Verify the person statment");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body); 

    }

}
