package org.learn.orderservice.orderMapper;

import org.learn.orderservice.DTO.OrderCommandDTO;
import org.learn.orderservice.model.OrderCommand;
import org.springframework.stereotype.Component;

@Component
public class OrderCommandMapper {

    public OrderCommandDTO toOrderCommandDTO(OrderCommand orderCommand){
        if(orderCommand == null){
            return null;
        }
        OrderCommandDTO orderCommandDTO = new OrderCommandDTO();
        orderCommandDTO.setOrderNumber(orderCommand.getOrderNumber());
        orderCommandDTO.setDate(orderCommand.getDate());
        orderCommandDTO.setTotalPrice(orderCommand.getTotalPrice());
        orderCommandDTO.setProduct(orderCommand.getProduct());
        orderCommandDTO.setCustomerNumber(orderCommand.getCustomerNumber());
        orderCommandDTO.setCustomerName(orderCommand.getCustomerName());
        return orderCommandDTO;

    }

    public OrderCommand toOrderCommand(OrderCommandDTO orderCommandDTO){
        if(orderCommandDTO == null){
            return null;
        }
        OrderCommand orderCommand = new OrderCommand();
        orderCommand.setOrderNumber(orderCommandDTO.getOrderNumber());
        orderCommand.setDate(orderCommandDTO.getDate());
        orderCommand.setTotalPrice(orderCommandDTO.getTotalPrice());
        orderCommand.setProduct(orderCommandDTO.getProduct());
        orderCommand.setCustomerNumber(orderCommandDTO.getCustomerNumber());
        orderCommand.setCustomerName(orderCommandDTO.getCustomerName());
        return orderCommand;
    }

}
