package com.customer.rewardpoints.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// @Entity annotation defines that a class can be mapped to
// a table
@Entity

// Representation of the table name
@Table(name = "CUSTOMER_TRANSACTIONS")
public class CustomerTransactions {

    @Id
    @Column(name = "TRANSACTION_ID")
    private int transactionId;
    @Column(name = "CUSTOMER_ID")
    private int customerId;
    @Column(name = "TRANSACTION_DATE")
    private Date transDate;
    @Column(name = "AMOUNT")
    private int amount;


    public int getTransactionId() {
        return transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

	
	
	

