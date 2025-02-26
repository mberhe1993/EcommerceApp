package com.example.productservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode
@Builder(toBuilder = false)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    private String customerNumber;
    private String  name;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String zip;

    //getters
    public String getCustomerNumber(){return customerNumber;}
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
    public String getStreet(){return street;}
    public String getCity(){return city;}
    public String getZip(){return zip;}

    //setters
    public void setCustomerNumber(String customerNumber){this.customerNumber = customerNumber;}
    public void setName(String name){this.name = name;}
    public void setPhone(String phone){this.phone = phone;}
    public void setEmail(String email){this.email = email;}
    public void setStreet(String street){this.street = street;}
    public void setCity(String city){this.city = city;}
    public void setZip(String zip){this.zip = zip;}

}
