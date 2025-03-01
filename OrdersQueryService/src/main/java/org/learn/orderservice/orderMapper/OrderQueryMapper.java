package org.learn.orderservice.orderMapper;

import org.learn.orderservice.DTO.OrderQueryDTO;
import org.learn.orderservice.model.OrderQuery;
import org.springframework.stereotype.Component;

@Component
public class OrderQueryMapper {

    public OrderQueryDTO toOrderQueryDTO(OrderQuery orderQuery){
        if(orderQuery == null){
            return null;
        }
        OrderQueryDTO orderQueryDTO = new OrderQueryDTO();
        orderQueryDTO.setCustomerName(orderQuery.getCustomerName());
        orderQueryDTO.setDate(orderQuery.getDate());
        orderQueryDTO.setTotalPrice(orderQuery.getTotalPrice());
        orderQueryDTO.setOrderNumber(orderQuery.getOrderNumber());
        orderQueryDTO.setProducts(orderQuery.getProducts());
        orderQueryDTO.setCustomerName(orderQuery.getCustomerName());

        return orderQueryDTO;

    }

    public OrderQuery toOrderQuery(OrderQueryDTO orderQueryDTO){
        if(orderQueryDTO == null){
            return null;
        }
        OrderQuery orderCommand = new OrderQuery();
        orderCommand.setOrderNumber(orderQueryDTO.getOrderNumber());
        orderCommand.setDate(orderQueryDTO.getDate());
        orderCommand.setTotalPrice(orderQueryDTO.getTotalPrice());
        orderCommand.setOrderNumber(orderQueryDTO.getOrderNumber());
        orderCommand.setProducts(orderQueryDTO.getProducts());
        orderCommand.setCustomerName(orderQueryDTO.getCustomerName());
        return orderCommand;
    }

}
