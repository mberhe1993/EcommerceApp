package com.example.customerservice.service;

import com.example.customerservice.model.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
     public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
    }
}
