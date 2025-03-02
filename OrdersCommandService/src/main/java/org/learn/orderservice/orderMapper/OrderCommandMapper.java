package org.learn.orderservice.orderMapper;

import lombok.Getter;
import lombok.Setter;
import org.learn.orderservice.DTO.OrderCommandDTO;
import org.learn.orderservice.model.OrderCommand;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class OrderCommandMapper {

    public OrderCommandDTO toOrderCommandDTO(OrderCommand orderCommand){
        if(orderCommand == null){
            return null;
        }
        return OrderCommandDTO.builder()
                        .orderNumber(orderCommand.getOrderNumber())
                        .date(orderCommand.getDate())
                        .totalPrice(orderCommand.getTotalPrice())
                        .product(orderCommand.getProduct())
                        .customerNumber(orderCommand.getCustomerNumber())
                        .customerName(orderCommand.getCustomerName())
                        .build();

    }

    public OrderCommand toOrderCommand(OrderCommandDTO orderCommandDTO){
        if(orderCommandDTO == null){
            return null;
        }
       return OrderCommand.builder()
                .orderNumber(orderCommandDTO.getOrderNumber())
                .date(orderCommandDTO.getDate())
                .totalPrice(orderCommandDTO.getTotalPrice())
                .product(orderCommandDTO.getProduct())
                .customerNumber(orderCommandDTO.getCustomerNumber())
                .customerName(orderCommandDTO.getCustomerName())
                .build();
    }

}
