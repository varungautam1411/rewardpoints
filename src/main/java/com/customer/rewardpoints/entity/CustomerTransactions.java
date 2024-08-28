package com.customer.rewardpoints.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


// @Entity annotation defines that a class can be mapped to
// a table
@Setter
@Getter
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
    private double amount;
}

	
	
	

