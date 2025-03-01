package com.example.customerservice.mapper;

import com.example.customerservice.DTO.CustomerDto;
import com.example.customerservice.model.Customer;

public class CustomerMapper {
    public static CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getCustomerNumber(), customer.getName(), customer.getEmail(),
                customer.getPhoneNumber(), customer.getStreet(), customer.getCity(), customer.getZip());
    }

    public static Customer toEntity(CustomerDto customerDto) {
        return new Customer(customerDto.getId(), customerDto.getCustomerNumber(), customerDto.getName(), customerDto.getEmail(),
                customerDto.getPhoneNumber(), customerDto.getStreet(), customerDto.getCity(), customerDto.getZip());
    }
}
