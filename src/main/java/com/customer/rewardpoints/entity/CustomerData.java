package com.customer.rewardpoints.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity annotation defines that a class can be mapped to
// a table
@Entity

// Representation of the table name
@Table(name = "CUSTOMER_DATA")
public class CustomerData {


    @Id
    @Column(name = "CUSTOMER_ID")
    private int customerId;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}



