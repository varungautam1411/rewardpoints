package com.customer.rewardpoints.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerRewards {

    public int customerId;

    public String customerName;

    public int lastMonthCustomerRewardPoints;

    public int secondLastMothCustomerRewardPoints;

    public int thirdLastMothCustomerRewardPoints;

    public int totalCustomerRewardPoints;
}
