package org.learn.orderservice.Domains;

public class OrderItem {
    private String productNumber; // Product Identifier
    private String productName;
    private int quantity; // Ordered Quantity
    private double price; // Price per unit

    public OrderItem(String productNumber, String productName, int quantity, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
