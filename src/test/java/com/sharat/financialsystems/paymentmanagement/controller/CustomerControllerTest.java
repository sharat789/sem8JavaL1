package com.sharat.financialsystems.paymentmanagement.controller;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import com.sharat.financialsystems.paymentmanagement.service.CustomerService;
import com.sharat.financialsystems.paymentmanagement.service.XMLTransformationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @Mock
    private XMLTransformationService xmlTransformationService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void testGetAllCustomers() throws Exception {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Jane");
        customer2.setLastName("Doe");

        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/customers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Doe"));

    }
}