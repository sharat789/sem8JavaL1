package com.sharat.financialsystems.paymentmanagement.repository;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Customer, Long> {

}
