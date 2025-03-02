package org.learn.orderservice.service;

import org.learn.orderservice.DTO.OrderQueryDTO;
import org.learn.orderservice.model.OrderQuery;
import org.learn.orderservice.orderMapper.OrderQueryMapper;
import org.learn.orderservice.repository.OrderQueryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    private static final Logger log = LoggerFactory.getLogger(OrderQueryServiceImpl.class);
    @Autowired
    private OrderQueryRepository OrderQueryRepository;;

    @Autowired
   private OrderQueryMapper OrderQueryMapper;;


    @Override
    public OrderQueryDTO getOrder(String orderNumber) {
        Optional<OrderQuery> OrderQueryOptional = OrderQueryRepository.findByOrderNumber(orderNumber);
        if (orderNumber.isEmpty()) {
            throw new RuntimeException(HttpStatus.NOT_FOUND + "Order not found");
        }

        OrderQuery OrderQuery = OrderQueryOptional.get();
        OrderQueryDTO OrderQueryDTO = OrderQueryMapper.toOrderQueryDTO(OrderQuery);
        log.info("Mapped OrderQueryDTO: {}", OrderQueryDTO);
        return OrderQueryDTO;
    }
}
