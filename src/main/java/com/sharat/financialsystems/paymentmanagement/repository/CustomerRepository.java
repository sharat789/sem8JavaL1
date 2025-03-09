package com.sharat.financialsystems.paymentmanagement.repository;

import com.sharat.financialsystems.paymentmanagement.model.Customer;
import com.sharat.financialsystems.paymentmanagement.model.CustomerAccount;
import com.sharat.financialsystems.paymentmanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.firstName = :firstName")
    Customer findCustomerByFirstName(@Param("firstName") String firstName);


    @Query("select a from CustomerAccount a where a.customer.id = :customerId")
    List<CustomerAccount> findAccountsByCustomerId(@Param("customerId") Long customerId);

    @Query("select t from Transaction t where t.account.id = :accountId")
    List<Transaction> findTransactionsByAccountId(@Param("accountId") Long accountId);
}
