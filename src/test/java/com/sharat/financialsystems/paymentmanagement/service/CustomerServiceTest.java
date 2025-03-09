package com.sharat.financialsystems.paymentmanagement.service;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import com.sharat.financialsystems.paymentmanagement.model.CustomerAccount;
import com.sharat.financialsystems.paymentmanagement.model.Transaction;
import com.sharat.financialsystems.paymentmanagement.repository.CustomerRepository;
import com.sharat.financialsystems.paymentmanagement.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Jane");
        customer2.setLastName("Doe");

        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());

        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetCustomerById() {
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer result = customerService.getCustomerById(1L);
        assertEquals("John", result.getFirstName());

        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCustomerByIdNotFound() {
        CustomerService customerService = new CustomerService(customerRepository);

        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        Customer result = customerService.getCustomerById(1L);
        assertNull(result);

        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCustomerByFirstName() {
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");

        when(customerRepository.findCustomerByFirstName("John")).thenReturn(customer);

        Customer result = customerService.getCustomerByFirstName("John");
        assertEquals("John", result.getFirstName());

        verify(customerRepository, times(1)).findCustomerByFirstName("John");
    }

    @Test
    void testGetAccountsByCustomerId() {
        CustomerService customerService = new CustomerService(customerRepository);

        CustomerAccount account1 = new CustomerAccount();
        account1.setId(1L);
        CustomerAccount account2 = new CustomerAccount();
        account2.setId(2L);

        List<CustomerAccount> accounts = Arrays.asList(account1, account2);

        when(customerRepository.findAccountsByCustomerId(1L)).thenReturn(accounts);

        List<CustomerAccount> result = customerService.getAccountsByCustomerId(1L);
        assertEquals(2, result.size());

        verify(customerRepository, times(1)).findAccountsByCustomerId(1L);
    }

    @Test
    void testGetTransactionsByAccountId() {
        CustomerService customerService = new CustomerService(customerRepository);

        Transaction transaction1 = new Transaction();
        transaction1.setId(1L);
        Transaction transaction2 = new Transaction();
        transaction2.setId(2L);

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2);

        when(customerRepository.findTransactionsByAccountId(1L)).thenReturn(transactions);

        List<Transaction> result = customerService.getTransactionsByAccountId(1L);
        assertEquals(2, result.size());

        verify(customerRepository, times(1)).findTransactionsByAccountId(1L);
    }
}