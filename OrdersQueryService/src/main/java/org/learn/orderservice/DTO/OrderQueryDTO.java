package org.learn.orderservice.DTO;

import org.learn.orderservice.Domains.OrderItem;
import org.learn.orderservice.Domains.PaymentInfo;

import java.util.List;

public class OrderQueryDTO {

    private String orderNumber; // Unique Order ID

    private String customerNumber; // Customer ID
    private String customerName; // Customer Name
    private List<OrderItem> products; // List of ordered products
    private double totalPrice; // Total Price of the Order
    private String date; // Order Date
    private PaymentInfo paymentInfo; // Payment Details
    private String quantity;

    public OrderQueryDTO() {
    }

    public OrderQueryDTO(String orderNumber, String customerNumber, String customerName, List<OrderItem> products, double totalPrice, String date, PaymentInfo paymentInfo, String quantity) {
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.products = products;
        this.totalPrice = totalPrice;
        this.date = date;
        this.paymentInfo = paymentInfo;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItem> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
