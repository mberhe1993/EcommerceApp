package org.learn.orderservice.service;

import org.learn.orderservice.DTO.OrderQueryDTO;

public interface OrderQueryService {

    OrderQueryDTO getOrder(String orderNumber);
}
