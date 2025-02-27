package com.example.productservice.utility.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(HttpStatus notFound, String message){
        super(message);
    }

}
