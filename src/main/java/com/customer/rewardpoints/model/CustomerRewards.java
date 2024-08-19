package com.customer.rewardpoints.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;


public class CustomerRewards {
    @Getter
    @Setter
    public int customerId;
    @Getter
    @Setter
    public String customerName;
    @Getter
    @Setter
    public int lastMonthCustomerRewardPoints;
    @Getter
    @Setter
    public int secondLastMothCustomerRewardPoints;
    @Getter
    @Setter
    public int thirdLastMothCustomerRewardPoints;
    @Getter
    @Setter
    public int totalCustomerRewardPoints;
}
