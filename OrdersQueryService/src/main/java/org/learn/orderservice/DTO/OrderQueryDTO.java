package org.learn.orderservice.DTO;

import lombok.*;
import org.learn.orderservice.Domains.OrderItem;
import org.learn.orderservice.Domains.PaymentInfo;

import java.util.List;

@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderQueryDTO {

    private String orderNumber;
    private String customerNumber;
    private String customerName;
    private List<OrderItem> products;
    private double totalPrice;
    private String date;
    private PaymentInfo paymentInfo;
    private String quantity;


}
