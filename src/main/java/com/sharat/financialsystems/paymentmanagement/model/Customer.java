package com.sharat.financialsystems.paymentmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "title")
    private String title;
    @Column(name = "middleInitial")
    private String middleInitial;
    @Column(name = "suffix")
    private String suffix;
    @Column(name = "age")
    private int age;
    @Column(name = "ssn")
    private int ssn;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name="emailAddress",unique = true)
    private String emailAddress;
    @Column(name="username",unique = true)
    private String username;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<CustomerAccount> customerAccounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CustomerAccount> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(List<CustomerAccount> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }
}