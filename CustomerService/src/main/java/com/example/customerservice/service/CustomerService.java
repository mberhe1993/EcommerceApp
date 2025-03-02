package com.example.customerservice.service;

import com.example.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
     Customer saveCustomer(Customer customer);
     List<Customer> getAllCustomers();
}
