package org.learn.orderservice.model;

import lombok.*;
import org.learn.orderservice.DTO.OrderItem;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@Document(collection = "order")
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommand {

    private String orderNumber;
    private LocalDate date;
    private Double totalPrice;
    private List<OrderItem> product;
    private String customerNumber;
    private String customerName;
    private String paymentNumber;

}
