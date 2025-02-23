package com.sharat.financialsystems.paymentmanagement.service;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import com.sharat.financialsystems.paymentmanagement.model.CustomerAccount;
import com.sharat.financialsystems.paymentmanagement.model.Transaction;
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

    public List<CustomerAccount> getAccountsByCustomerId(Long customerId) {
        return customerRepository.findAccountsByCustomerId(customerId);
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return customerRepository.findTransactionsByAccountId(accountId);
    }
}