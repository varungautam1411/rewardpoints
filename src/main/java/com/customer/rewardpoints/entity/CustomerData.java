package com.customer.rewardpoints.entity;


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
@Table(name = "CUSTOMER_DATA")
public class CustomerData {
    @Id
    @Column(name = "CUSTOMER_ID")
    private int customerId;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
}



