package com.example.customerservice.model;

public class Customer {
    private String customerId;
    private String CustomerNumber;
    private String name;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String zip;

    public Customer(String id, String CustomerNumber, String name, String email, String phone, String street, String city, String zip) {
        this.customerId = id;
        this.CustomerNumber = CustomerNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public String getId() {
        return customerId;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public void setCustomerId(String id) {
        this.customerId = id;
    }

    public void setCustomerNumber(String CustomerNumber) {
        this.CustomerNumber = CustomerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
