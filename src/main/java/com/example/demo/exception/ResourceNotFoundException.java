package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{

//    public ResourceNotFoundException(HttpStatus status, String message) {
//        super(status, message);
//    }
    public ResourceNotFoundException(String resourceClass, Integer id){
        super(  HttpStatus.NOT_FOUND,
                String.format("%s id = %d is not found",resourceClass,id)
        );
    }
}
