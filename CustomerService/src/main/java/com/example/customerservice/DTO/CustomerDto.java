package com.example.customerservice.DTO;

public class CustomerDto {
    private String id;
    private String customerNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String street;
    private String city;
    private String zip;

    public CustomerDto() {
    }

    public CustomerDto(String id, String customerNumber, String name, String email, String phoneNumber, String street, String city, String zip) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
