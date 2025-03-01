package org.learn.orderservice.service;

import org.learn.orderservice.DTO.OrderCommandDTO;

public interface OrderCommandService {
    OrderCommandDTO placeOrder(OrderCommandDTO orderCommandDTO);

    OrderCommandDTO getOrder(String orderNumber);
}
