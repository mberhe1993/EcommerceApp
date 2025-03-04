package org.learn.orderservice.controller;

import org.learn.orderservice.DTO.*;
import org.learn.orderservice.service.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderCommandController {

    @Autowired
    private OrderCommandService orderCommandService;


    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestBody OrderCommandDTO orderCommandDTO) {
        try {

            OrderCommandDTO savedOrder = orderCommandService.placeOrder(orderCommandDTO);
            return ResponseEntity.ok(savedOrder);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable String orderNumber) {
        OrderCommandDTO orderDetails = orderCommandService.getOrder(orderNumber);
        if (orderDetails == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderDetails);
    }

}
