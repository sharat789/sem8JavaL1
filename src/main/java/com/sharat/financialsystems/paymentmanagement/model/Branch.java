package com.sharat.financialsystems.paymentmanagement.model;

import jakarta.persistence.*;

/**
 * Entity representing a Branch in the payment management system.
 */
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String branchCode;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNumber;

    /**
     * Gets the id of the branch.
     * @return the id of the branch.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the branch.
     * @param id the id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the branch code.
     * @return the branch code.
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the branch code.
     * @param branchCode the branch code to set.
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * Gets the name of the branch.
     * @return the name of the branch.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the branch.
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the branch.
     * @return the address of the branch.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the branch.
     * @param address the address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the city where the branch is located.
     * @return the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the branch is located.
     * @param city the city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state where the branch is located.
     * @return the state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state where the branch is located.
     * @param state the state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zip code of the branch.
     * @return the zip code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code of the branch.
     * @param zipCode the zip code to set.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the country where the branch is located.
     * @return the country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country where the branch is located.
     * @param country the country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the phone number of the branch.
     * @return the phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the branch.
     * @param phoneNumber the phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}