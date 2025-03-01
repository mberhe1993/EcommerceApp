package org.learn.orderservice.service;

import org.learn.orderservice.DTO.OrderCommandDTO;
import org.learn.orderservice.model.OrderCommand;
import org.learn.orderservice.orderMapper.OrderCommandMapper;
import org.learn.orderservice.repository.OrderCommandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private static final Logger log = LoggerFactory.getLogger(OrderCommandServiceImpl.class);
    @Autowired
    private OrderCommandRepository orderCommandRepository;

    @Autowired
   private OrderCommandMapper orderCommandMapper;

    @Autowired
    private KafkaTemplate<String, OrderCommandDTO> kafkaTemplate;

    private static final String ORDER_TOPIC = "order-events"; // ✅ Topic name

    @Override
    public OrderCommandDTO placeOrder(OrderCommandDTO dto) {

        OrderCommand orderCommand = orderCommandMapper.toOrderCommand(dto);
        OrderCommand savedOrderCommand = orderCommandRepository.save(orderCommand);
        OrderCommandDTO savedOrder = orderCommandMapper.toOrderCommandDTO(savedOrderCommand);
        log.info("Saved OrderCommandDTO: {}", savedOrder);
        kafkaTemplate.send(ORDER_TOPIC, savedOrder);  // ✅ Sending event to Kafka
        return savedOrder;
    }

    @Override
    public OrderCommandDTO getOrder(String orderNumber) {
        Optional<OrderCommand> orderCommandOptional = orderCommandRepository.findByOrderNumber(orderNumber);
        if (orderNumber.isEmpty()) {
            throw new RuntimeException(HttpStatus.NOT_FOUND + "Order not found");
        }

        OrderCommand orderCommand = orderCommandOptional.get();
        OrderCommandDTO orderCommandDTO = orderCommandMapper.toOrderCommandDTO(orderCommand);
        log.info("Mapped OrderCommandDTO: {}", orderCommandDTO);
        return orderCommandDTO;
    }
}
