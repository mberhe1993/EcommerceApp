package org.learn.orderservice.Domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {
    private String date;
    private double amount;
    private String orderNumber;
    private String customerNumber;
    private String paymentStatus;

}
