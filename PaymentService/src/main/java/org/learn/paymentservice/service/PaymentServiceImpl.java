package org.learn.paymentservice.service;

import lombok.extern.slf4j.Slf4j;
import org.learn.paymentservice.DTO.PaymentDTO;
import org.learn.paymentservice.exception.PaymentNotFoundException;
import org.learn.paymentservice.mapper.PaymentMapper;
import org.learn.paymentservice.model.Payment;
import org.learn.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

   @Autowired
    private PaymentRepository paymentRepository;

   @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public PaymentDTO addPayment(PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.toPayment(paymentDTO);
        Payment savePayment = paymentRepository.save(payment);
        return paymentMapper.toDto(savePayment);
    }

    @Override
    public PaymentDTO getPayment(String paymentNumber) {
        Optional<Payment> paymentOptional = paymentRepository.findByOrderNumber(paymentNumber);
        if(paymentOptional.isEmpty()){
            log.info("Product Not Found for a productNumber: {}", paymentNumber);
                throw new PaymentNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found for a productNumber: " + paymentNumber);
            }
            Payment payment = paymentOptional.get();

            PaymentDTO paymentDTO = paymentMapper.toDto(payment);
           log.info("Mapped ProductDTO: {}", paymentDTO);
            return paymentDTO;
        }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        if(payments.isEmpty()){
            log.info("No Products Found");
            throw new PaymentNotFoundException(HttpStatus.NOT_FOUND, "No Payments Found");
        }
        return payments.stream()
                .map(paymentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO updatePayment(String paymentNumber, PaymentDTO paymentDTO) {
        Optional<Payment> paymentOptional = paymentRepository.findByOrderNumber(paymentNumber);
        if(paymentOptional.isEmpty()){
            log.info("Product Not Found for a productNumber That you need to update: {}", paymentNumber);
            throw new PaymentNotFoundException(HttpStatus.NOT_FOUND, "Payment Not Found: " + paymentNumber);
        }
        Payment payment = paymentOptional.get();
        payment.setDate(paymentDTO.getDate());
        payment.setAmount(paymentDTO.getAmount());
        payment.setOrderNumber(paymentDTO.getOrderNumber());
        payment.setCustomerNumber(paymentDTO.getCustomerNumber());

        Payment updatedPayment = paymentRepository.save(payment);
        return paymentMapper.toDto(updatedPayment);
    }

    @Override
    public void deletePayment(String paymentNumber) {
        Optional<Payment> paymentOptional = paymentRepository.findByOrderNumber(paymentNumber);
        if(paymentOptional.isEmpty()){
            log.info("Payment Not Found for a paymentNumber That you need to delete: {}", paymentNumber);
            throw new PaymentNotFoundException(HttpStatus.NOT_FOUND, "Payment Not Found: " + paymentNumber);
        }
        paymentRepository.delete(paymentOptional.get());
    }

}
