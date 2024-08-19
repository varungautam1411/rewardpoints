package com.customer.rewardpoints.service;

import com.customer.rewardpoints.entity.CustomerTransactions;
import com.customer.rewardpoints.model.CustomerRewards;


import java.util.List;


public interface CustomerRewardsService {
    public CustomerRewards prepareRewardsList(List<CustomerTransactions> list);
}