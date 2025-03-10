package com.example.customerservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String id;
    private String customerNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String street;
    private String city;
    private String zip;


}
