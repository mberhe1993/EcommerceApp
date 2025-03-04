package org.learn.paymentservice.controller;


import org.learn.paymentservice.DTO.PaymentDTO;
import org.learn.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<?> addPayment(@RequestBody PaymentDTO paymentDTO){
        return ok(paymentService.addPayment(paymentDTO));
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getPayment(@PathVariable String orderNumber){
        PaymentDTO paymentDTO = paymentService.getPayment(orderNumber);
        if(paymentDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(paymentDTO);
    }


    @PutMapping("/update/{orderNumber}")
    public ResponseEntity<?> updatePayment(@PathVariable String orderNumber, @RequestBody PaymentDTO paymentDTO){
        PaymentDTO updatePayment = paymentService.updatePayment(orderNumber, paymentDTO);
        if(updatePayment == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(updatePayment);
    }

    @DeleteMapping("/delete/{paymentNumber}")
    public ResponseEntity<?> deletePayment(@PathVariable String orderNumber){
        paymentService.deletePayment(orderNumber);
        return ok("Payment Deleted Successfully");
    }

}
