package com.sharat.financialsystems.paymentmanagement.repository;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Alternatively, using a custom query with the @Query annotation:
    @Query("select c from Customer c where c.firstName = :firstName")
    Customer findCustomerByFirstName(@Param("firstName") String firstName);
}
