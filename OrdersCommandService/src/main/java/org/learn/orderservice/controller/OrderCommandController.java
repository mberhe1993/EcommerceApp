package org.learn.orderservice.controller;

import org.learn.orderservice.DTO.OrderCommandDTO;
import org.learn.orderservice.service.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {

    @Autowired
    private OrderCommandService orderCommandService;



    @PostMapping("/")
    public ResponseEntity<?> placeOrder(@RequestBody OrderCommandDTO orderCommandDTO) {
        return ResponseEntity.ok(orderCommandService.placeOrder(orderCommandDTO));
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable String orderNumber) {
        return ResponseEntity.ok(orderCommandService.getOrder(orderNumber));
    }
}
