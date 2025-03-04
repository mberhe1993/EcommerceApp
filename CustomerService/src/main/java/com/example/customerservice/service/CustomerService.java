package com.example.customerservice.service;

import com.example.customerservice.DTO.CustomerDto;
import com.example.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
     CustomerDto saveCustomer(CustomerDto customerDto);
     List<CustomerDto> getAllCustomers();

     CustomerDto getCustomer(String customerNumber);
}
