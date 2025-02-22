package com.sharat.financialsystems.paymentmanagement.service;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import com.sharat.financialsystems.paymentmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByFirstName(String firstName) {
        return customerRepository.findCustomerByFirstName(firstName);
    }

    public List<Customer> getAllCustomersWithAccountsAndTransactions() {
        return customerRepository.findAllCustomersWithAccountsAndTransactions();
    }
}