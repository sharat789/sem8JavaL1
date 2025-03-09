package com.sharat.financialsystems.paymentmanagement.model;

import jakarta.persistence.*;

/**
 * Entity representing an Account Level in the payment management system.
 */
@Entity
@Table(name = "account_level")
public class AccountLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Boolean overdraftAllowed;
    private Integer dailyWithdrawalLimit;
    private Integer monthlyMaxTransfersAllowed;

    /**
     * Gets the id of the account level.
     * @return the id of the account level.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the account level.
     * @param id the id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the account level.
     * @return the name of the account level.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the account level.
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if overdraft is allowed.
     * @return true if overdraft is allowed, otherwise false.
     */
    public Boolean getOverdraftAllowed() {
        return overdraftAllowed;
    }

    /**
     * Sets the overdraft allowed status.
     * @param overdraftAllowed the overdraft status to set.
     */
    public void setOverdraftAllowed(Boolean overdraftAllowed) {
        this.overdraftAllowed = overdraftAllowed;
    }

    /**
     * Gets the daily withdrawal limit.
     * @return the daily withdrawal limit.
     */
    public Integer getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    /**
     * Sets the daily withdrawal limit.
     * @param dailyWithdrawalLimit the daily withdrawal limit to set.
     */
    public void setDailyWithdrawalLimit(Integer dailyWithdrawalLimit) {
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }

    /**
     * Gets the monthly maximum transfers allowed.
     * @return the monthly maximum transfers allowed.
     */
    public Integer getMonthlyMaxTransfersAllowed() {
        return monthlyMaxTransfersAllowed;
    }

    /**
     * Sets the monthly maximum transfers allowed.
     * @param monthlyMaxTransfersAllowed the monthly maximum transfers to set.
     */
    public void setMonthlyMaxTransfersAllowed(Integer monthlyMaxTransfersAllowed) {
        this.monthlyMaxTransfersAllowed = monthlyMaxTransfersAllowed;
    }
}