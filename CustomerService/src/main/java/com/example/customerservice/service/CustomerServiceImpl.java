package com.example.customerservice.service;

import com.example.customerservice.DTO.CustomerDto;
import com.example.customerservice.mapper.CustomerMapper;
import com.example.customerservice.model.Customer;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
     public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
    return CustomerMapper.toDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()){
            log.info("No Products Found");
            throw new CustomerNotFoundException(HttpStatus.NOT_FOUND, "No Products Found");
        }
        return customers.stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomer(String customerNumber) {
        Optional<Customer> customer = customerRepository.findByCustomerNumber(customerNumber);
        if (customer.isEmpty()){
            log.info("Customer Not Found for a customerNumber: {}", customerNumber);
            throw new CustomerNotFoundException(HttpStatus.NOT_FOUND, "Customer Not Found for a customerNumber: " + customerNumber);
        }
        Customer customer1 = customer.get();
        CustomerDto customerDto = CustomerMapper.toDto(customer1);
        log.info("Mapped CustomerDTO: {}", customerDto);
        return customerDto;
    }
}
