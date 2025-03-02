package org.learn.orderservice.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.learn.orderservice.model.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder(toBuilder = true)
public class OrderCommandDTO {

    private String orderNumber;
    private LocalDate date;
    private BigDecimal totalPrice;
    private List<OrderItem> product;
    private String customerNumber;
    private String customerName;

}
