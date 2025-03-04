package org.learn.orderservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
