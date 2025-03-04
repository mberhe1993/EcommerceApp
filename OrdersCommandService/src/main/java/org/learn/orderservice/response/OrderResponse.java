package org.learn.orderservice.response;

import java.util.List;

public class OrderResponse {
    private String orderNumber;
    private int customerName;
    private List<OrderItemResponse> items;
    private double totalPrice;
    private String paymentStatus;
}
