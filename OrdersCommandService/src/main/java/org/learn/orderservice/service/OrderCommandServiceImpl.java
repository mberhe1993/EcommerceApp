package org.learn.orderservice.service;

import lombok.extern.slf4j.Slf4j;
import org.learn.orderservice.DTO.*;
import org.learn.orderservice.model.OrderCommand;
import org.learn.orderservice.orderMapper.OrderCommandMapper;
import org.learn.orderservice.repository.OrderCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderCommandServiceImpl implements OrderCommandService {

    @Autowired
    private OrderCommandRepository orderRepository;

    @Autowired
    private OrderCommandMapper orderCommandMapper;

    @Autowired
    private KafkaTemplate<String, OrderCommandDTO> kafkaTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${spring.data.kafka.order-topic}")
    private static final String ORDER_TOPIC = "order-events";

    @Override
    public OrderCommandDTO placeOrder(OrderCommandDTO orderCommandDTO) {

        if (orderCommandDTO == null) {
            throw new RuntimeException(HttpStatus.BAD_REQUEST + " Order not found");
        }

        // Fetch customer info
        CustomerDto customer = webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/customers/{customerNumber}", orderCommandDTO.getCustomerNumber())
                .retrieve()
                .bodyToMono(CustomerDto.class)
                .block();

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        List<OrderItem> fetchedProducts = new ArrayList<>();
        double totalPrice = 0.0;

        // Fetch product info and calculate total price
        for (OrderItem item : orderCommandDTO.getProduct()) {
            ProductDTO product = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8084/products/{productNumber}", item.getProductNumber())
                    .retrieve()
                    .bodyToMono(ProductDTO.class)
                    .block();

            if (product == null) {
                throw new IllegalArgumentException("Product not found: " + item.getProductNumber());
            }

            // Update product details in order items for saving
            item.setPrice(product.getPrice());
            item.setProductName(product.getName());
            totalPrice += product.getPrice() * item.getQuantity();
            fetchedProducts.add(item);
        }

        // Process payment
        PaymentDTO payment = PaymentDTO.builder()
                .amount(totalPrice)
                .customerNumber(orderCommandDTO.getCustomerNumber())
                .orderNumber(orderCommandDTO.getOrderNumber())
                .build();

        PaymentDTO paymentResponse = webClientBuilder.build()
                .post()
                .uri("http://localhost:8083/payments/{orderNumber}", orderCommandDTO.getOrderNumber())
                .bodyValue(payment)
                .retrieve()
                .bodyToMono(PaymentDTO.class)
                .block();

        if (paymentResponse == null) {
            throw new IllegalArgumentException("Payment processing failed");
        }

        // Save the updated orderCommandDTO to the database
        orderCommandDTO.setTotalPrice(totalPrice);
        orderCommandDTO.setCustomerName(customer.getName());
        orderCommandDTO.setOrderNumber(paymentResponse.getOrderNumber());
        orderCommandDTO.setProduct(fetchedProducts);

        OrderCommand orderCommand = orderCommandMapper.toOrderCommand(orderCommandDTO); // Map DTO to Entity
        OrderCommand savedOrderCommand = orderRepository.save(orderCommand);
        OrderCommandDTO savedOrderDTO = orderCommandMapper.toOrderCommandDTO(savedOrderCommand); // Map Entity back to DTO

        // Publish event to Kafka
        try {
            kafkaTemplate.send(ORDER_TOPIC, savedOrderDTO);
            log.info("Order event published to Kafka topic '{}': {}", ORDER_TOPIC, savedOrderDTO);
        } catch (Exception e) {
            log.error("Error while publishing order event to Kafka: {}", e.getMessage(), e);
            throw new RuntimeException("Error while publishing order event", e);
        }

        return savedOrderDTO;
    }

    @Override
    public OrderCommandDTO getOrder(String orderNumber) {
        OrderCommand order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order not found for order number: " + orderNumber));

        return orderCommandMapper.toOrderCommandDTO(order);
    }


}