package org.learn.orderservice.DTO;

import org.learn.orderservice.model.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class OrderCommandDTO {

    private String orderNumber;
    private LocalDate date;
    private BigDecimal totalPrice;
    private List<OrderItem> product;
    private String customerNumber;
    private String customerName;

    public OrderCommandDTO() {
    }

    public OrderCommandDTO(String orderNumber, LocalDate date, BigDecimal totalPrice, List<OrderItem> product, String customerNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.totalPrice = totalPrice;
        this.product = product;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getProduct() {
        return product;
    }

    public void setProduct(List<OrderItem> product) {
        this.product = product;
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
}
