package org.learn.paymentservice.mapper;


import org.learn.paymentservice.DTO.PaymentDTO;
import org.learn.paymentservice.model.Payment;
import org.springframework.stereotype.Component;


@Component
public class PaymentMapper {

    public PaymentDTO toDto(Payment payment){
        if(payment == null){
            return null;
        }
        return PaymentDTO.builder()
                .id(payment.getId())
                .date(payment.getDate())
                .amount(payment.getAmount())
                .orderNumber(payment.getOrderNumber())
                .customerNumber(payment.getCustomerNumber())
                .build();

    }

    public  Payment toPayment(PaymentDTO paymentDTO){
        if(paymentDTO == null){
            return null;
        }
          return Payment.builder()
                          .amount(paymentDTO.getAmount())
                            .customerNumber(paymentDTO.getCustomerNumber())
                            .date(paymentDTO.getDate())
                            .orderNumber(paymentDTO.getOrderNumber())
                            .id(paymentDTO.getId())
                .build();
    }
}
