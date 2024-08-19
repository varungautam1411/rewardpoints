package com.customer.rewardpoints.model;

import org.springframework.context.annotation.Bean;


public class CustomerRewards {


    public int customerId;


    public String customerName;
    public float lastMonthCustomerRewardPoints;
    public float secondLastMothCustomerRewardPoints;
    public float thirdLastMothCustomerRewardPoints;
    public float totalCustomerRewardPoints;

    public int getCustomerId() {
        return customerId;
    }

    public float getLastMonthCustomerRewardPoints() {
        return lastMonthCustomerRewardPoints;
    }

    public float getSecondLastMothCustomerRewardPoints() {
        return secondLastMothCustomerRewardPoints;
    }

    public float getThirdLastMothCustomerRewardPoints() {
        return thirdLastMothCustomerRewardPoints;
    }

    public float getTotalCustomerRewardPoints() {
        return totalCustomerRewardPoints;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setLastMonthCustomerRewardPoints(float lastMonthCustomerRewardPoints) {
        this.lastMonthCustomerRewardPoints = lastMonthCustomerRewardPoints;
    }

    public void setSecondLastMothCustomerRewardPoints(float secondLastMothCustomerRewardPoints) {
        this.secondLastMothCustomerRewardPoints = secondLastMothCustomerRewardPoints;
    }

    public void setThirdLastMothCustomerRewardPoints(float thirdLastMothCustomerRewardPoints) {
        this.thirdLastMothCustomerRewardPoints = thirdLastMothCustomerRewardPoints;
    }

    public void setTotalCustomerRewardPoints(float totalCustomerRewardPoints) {
        this.totalCustomerRewardPoints = totalCustomerRewardPoints;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
