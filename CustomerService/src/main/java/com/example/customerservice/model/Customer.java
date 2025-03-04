package com.example.customerservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "customers")
public class Customer {
    private String customerId;
    private String customerNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String street;
    private String city;
    private String zip;

}
