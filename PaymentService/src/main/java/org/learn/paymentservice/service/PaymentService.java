package org.learn.paymentservice.service;


import org.learn.paymentservice.DTO.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO addPayment(PaymentDTO paymentDTO);

    PaymentDTO getPayment(String orderNumber);

    List<PaymentDTO> getAllPayments();

    PaymentDTO updatePayment(String orderNumber, PaymentDTO paymentDTO);

    void deletePayment(String orderNumber);
}
