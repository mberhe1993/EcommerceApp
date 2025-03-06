package org.learn.orderservice.controller;

import org.learn.orderservice.DTO.OrderQueryDTO;
import org.learn.orderservice.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderQueryController {

    @Autowired
    private OrderQueryService orderQueryService;


    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable String orderNumber) {
        return ResponseEntity.ok(orderQueryService.getOrder(orderNumber));
    }
}
