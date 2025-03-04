package org.learn.paymentservice.exception;

import org.springframework.http.HttpStatus;

public class PaymentNotFoundException extends RuntimeException{

    public PaymentNotFoundException(HttpStatus notFound, String message){
        super(message);
    }

}
