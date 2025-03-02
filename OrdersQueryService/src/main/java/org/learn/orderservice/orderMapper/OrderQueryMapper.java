package org.learn.orderservice.orderMapper;

import lombok.Getter;
import lombok.Setter;
import org.learn.orderservice.DTO.OrderQueryDTO;
import org.learn.orderservice.model.OrderQuery;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class OrderQueryMapper {

    public OrderQueryDTO toOrderQueryDTO(OrderQuery orderQuery){
        if(orderQuery == null){
            return null;
        }
       return OrderQueryDTO.builder()
                .orderNumber(orderQuery.getOrderNumber())
                .date(orderQuery.getDate())
                .totalPrice(orderQuery.getTotalPrice())
                .products(orderQuery.getProducts())
                .customerName(orderQuery.getCustomerName())
                .build();

    }

    public OrderQuery toOrderQuery(OrderQueryDTO orderQueryDTO){
        if(orderQueryDTO == null){
            return null;
        }
       return OrderQuery.builder()
                .orderNumber(orderQueryDTO.getOrderNumber())
                .date(orderQueryDTO.getDate())
                .totalPrice(orderQueryDTO.getTotalPrice())
                .products(orderQueryDTO.getProducts())
                .customerName(orderQueryDTO.getCustomerName())
                .build();
    }

}
