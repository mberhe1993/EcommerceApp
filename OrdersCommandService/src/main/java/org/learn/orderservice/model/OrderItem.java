package org.learn.orderservice.model;

import java.math.BigDecimal;

public class OrderItem {
    private String productNumber; // ✅ Unique Product ID
    private String productName;
    private int quantity;         // ✅ Integer instead of String
    private BigDecimal price;     // ✅ Price of each product

    public OrderItem() {
    }
    public OrderItem(String productNumber, String productName, int quantity, BigDecimal price) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
