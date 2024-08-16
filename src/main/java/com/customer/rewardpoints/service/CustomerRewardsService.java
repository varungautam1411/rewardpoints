package com.customer.rewardpoints.service;

import com.customer.rewardpoints.entity.CustomerTransactions;
import com.customer.rewardpoints.model.CustomerRewards;
import org.springframework.context.annotation.Bean;


public interface CustomerRewardsService {
    public CustomerRewards prepareRewardsList(CustomerRewards customerRewards) ;
}