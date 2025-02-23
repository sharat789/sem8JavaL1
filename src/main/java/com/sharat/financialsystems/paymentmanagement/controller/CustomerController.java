package com.sharat.financialsystems.paymentmanagement.controller;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import com.sharat.financialsystems.paymentmanagement.model.CustomerAccount;
import com.sharat.financialsystems.paymentmanagement.model.Transaction;
import com.sharat.financialsystems.paymentmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/firstName")
    public Customer getCustomerByFirstName(@RequestParam("firstName") String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }

    @GetMapping("/{customerId}/accounts")
    public List<CustomerAccount> getAccountsByCustomerId(@PathVariable Long customerId) {
        return customerService.getAccountsByCustomerId(customerId);
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public List<Transaction> getTransactionsByAccountId(@PathVariable Long accountId) {
        return customerService.getTransactionsByAccountId(accountId);
    }
}