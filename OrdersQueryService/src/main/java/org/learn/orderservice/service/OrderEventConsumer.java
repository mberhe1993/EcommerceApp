package org.learn.orderservice.service;

import org.learn.orderservice.model.OrderQuery;
import org.learn.orderservice.repository.OrderQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class OrderEventConsumer {

    @Autowired
    private OrderQueryRepository orderQueryRepository;

    @KafkaListener(topics = "order-events", groupId = "order-query-group")
    public void consumeOrderEvent(OrderQuery order) {
        System.out.println("Received order event: " + order.getOrderNumber());
        orderQueryRepository.save(order);  // ✅ Syncing read database
    }

}
