package com.sharat.financialsystems.paymentmanagement.model;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOverdraftAllowed() {
        return overdraftAllowed;
    }

    public void setOverdraftAllowed(Boolean overdraftAllowed) {
        this.overdraftAllowed = overdraftAllowed;
    }

    public Integer getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public void setDailyWithdrawalLimit(Integer dailyWithdrawalLimit) {
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }

    public Integer getMonthlyMaxTransfersAllowed() {
        return monthlyMaxTransfersAllowed;
    }

    public void setMonthlyMaxTransfersAllowed(Integer monthlyMaxTransfersAllowed) {
        this.monthlyMaxTransfersAllowed = monthlyMaxTransfersAllowed;
    }
}
