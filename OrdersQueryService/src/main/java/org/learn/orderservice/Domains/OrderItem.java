package org.learn.orderservice.Domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private String productNumber;
    private String productName;
    private int quantity;
    private double price;


}
