package com.example.customerservice.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(HttpStatus notFound, String message) {
        super(message);
        {
        }
    }
}
