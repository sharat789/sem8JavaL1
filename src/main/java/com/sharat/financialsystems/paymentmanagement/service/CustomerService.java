package com.sharat.financialsystems.paymentmanagement.service;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import com.sharat.financialsystems.paymentmanagement.model.CustomerAccount;
import com.sharat.financialsystems.paymentmanagement.model.Transaction;
import com.sharat.financialsystems.paymentmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing customers and their accounts.
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    /**
     * Constructs a CustomerService with the given CustomerRepository.
     *
     * @param customerRepository the repository used to manage customers.
     */
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Retrieves all customers.
     *
     * @return a list of all customers.
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return the customer with the given ID, or null if not found.
     */
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a customer by their first name.
     *
     * @param firstName the first name of the customer to retrieve.
     * @return the customer with the given first name.
     */
    public Customer getCustomerByFirstName(String firstName) {
        return customerRepository.findCustomerByFirstName(firstName);
    }

    /**
     * Retrieves the accounts associated with a customer.
     *
     * @param customerId the ID of the customer.
     * @return a list of accounts associated with the customer.
     */
    public List<CustomerAccount> getAccountsByCustomerId(Long customerId) {
        return customerRepository.findAccountsByCustomerId(customerId);
    }

    /**
     * Retrieves the transactions associated with an account.
     *
     * @param accountId the ID of the account.
     * @return a list of transactions associated with the account.
     */
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return customerRepository.findTransactionsByAccountId(accountId);
    }
}