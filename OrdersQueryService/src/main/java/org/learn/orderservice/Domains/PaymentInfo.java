package org.learn.orderservice.Domains;

public class PaymentInfo {
    private String date; // Payment Date
    private double amount; // Payment Amount
    private String orderNumber; // Associated Order Number
    private String customerNumber; // Associated Customer Number
    private String paymentStatus; // SUCCESS, FAILED, PENDING

    public PaymentInfo() {
    }
    public PaymentInfo(String date, double amount, String orderNumber, String customerNumber, String paymentStatus) {
        this.date = date;
        this.amount = amount;
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
        this.paymentStatus = paymentStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
