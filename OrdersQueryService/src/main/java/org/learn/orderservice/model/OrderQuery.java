package org.learn.orderservice.model;

import lombok.*;
import org.learn.orderservice.Domains.OrderItem;
import org.learn.orderservice.Domains.PaymentInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders_read")
public class OrderQuery {

    @Id
    private String orderNumber;
    private String customerNumber;
    private String customerName;
    private List<OrderItem> products;
    private double totalPrice;
    private String date;
    private PaymentInfo paymentInfo;

}
