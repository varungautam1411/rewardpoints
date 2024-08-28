package com.customer.rewardpoints.service;


import com.customer.rewardpoints.model.CustomerRewards;




public interface CustomerRewardsService {
    public CustomerRewards prepareRewardsList(int customerId);
}