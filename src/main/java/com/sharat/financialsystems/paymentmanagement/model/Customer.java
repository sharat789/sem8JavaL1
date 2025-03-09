package com.sharat.financialsystems.paymentmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@Entity
@XmlRootElement(name = "customer")
@XmlType(propOrder = {"id", "firstName", "lastName", "title", "middleInitial", "suffix", "age", "ssn", "phoneNumber", "emailAddress", "username", "customerAccounts"})
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

    private String emailAddress;

    @Column(name = "username", unique = true)
    private String username;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<CustomerAccount> customerAccounts;

    @XmlElement
    @JsonProperty
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    @JsonProperty
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    @JsonProperty
    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    @XmlElement
    @JsonProperty
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @XmlElement
    @JsonProperty
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    @JsonProperty
    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @XmlElement
    @JsonProperty
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement
    @JsonProperty
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @XmlElement
    @JsonProperty
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement(name = "account")
    @JsonProperty
    public List<CustomerAccount> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(List<CustomerAccount> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }
}