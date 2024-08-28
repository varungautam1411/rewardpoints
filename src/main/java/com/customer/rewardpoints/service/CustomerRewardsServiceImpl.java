package com.customer.rewardpoints.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


import com.customer.rewardpoints.RewardpointsApplication;
import com.customer.rewardpoints.exception.MonthOlderThanThreeException;
import com.customer.rewardpoints.exception.NotCurrentYearException;
import com.customer.rewardpoints.exception.RecentTransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import com.customer.rewardpoints.entity.CustomerTransactions;
import com.customer.rewardpoints.model.CustomerRewards;
import com.customer.rewardpoints.repository.CustomerTransactionsRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.lang.Math.floor;

@Service
public class CustomerRewardsServiceImpl implements CustomerRewardsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRewardsServiceImpl.class);

    @Autowired
    CustomerTransactionsRepository customerTransactionsRepository;
   


    public  CustomerRewards prepareRewardsList(int customerID) {
        logger.info("Inside CustomerRewardsServiceImpl prepareRewardsList");
        List<CustomerTransactions> list = customerTransactionsRepository.findAllByCustomerId(customerID);
        CustomerRewards customerRewards = new CustomerRewards();

        customerRewards.setCustomerId(list.get(0).getCustomerId());
        for (CustomerTransactions customerTransactions : list) {
            Date dateTemp = customerTransactions.getTransDate();
            int yearOfPurchase = dateTemp.getYear() + 1900;
            int month = dateTemp.getMonth() + 1;
            GregorianCalendar date = new GregorianCalendar();
            int currentMonth = date.get(Calendar.MONTH) + 1;
            int currentYear = date.get(Calendar.YEAR);
            logger.info("The current year is " + currentYear + " and the purchase year is " + yearOfPurchase);
            logger.info("The current month is " + currentMonth + " and the purchase month is " + month);
            if (currentYear != yearOfPurchase) {
                throw new NotCurrentYearException();
            }
            logger.info("Amount spent is " + customerTransactions.getAmount());
            int rewards = calculateReward(customerTransactions.getAmount());
            if (currentMonth - month == 1) {
                customerRewards.setLastMonthCustomerRewardPoints(customerRewards.getLastMonthCustomerRewardPoints() + rewards);
                customerRewards.setTotalCustomerRewardPoints(customerRewards.getTotalCustomerRewardPoints() + rewards);
            } else if (currentMonth - month == 2) {
                customerRewards.setSecondLastMothCustomerRewardPoints(customerRewards.getSecondLastMothCustomerRewardPoints() + rewards);
                customerRewards.setTotalCustomerRewardPoints(customerRewards.getTotalCustomerRewardPoints() + rewards);
            } else if (currentMonth - month == 3) {
                customerRewards.setThirdLastMothCustomerRewardPoints(customerRewards.getThirdLastMothCustomerRewardPoints() + rewards);
                customerRewards.setTotalCustomerRewardPoints(customerRewards.getTotalCustomerRewardPoints() + rewards);
            } else if (currentMonth - month < 1) {
                throw new RecentTransactionException();
            } else {
                throw new MonthOlderThanThreeException();
            }
        }
        return customerRewards;
    }

    public int calculateReward(double amount) {
System.out.println("The amount is " + amount);
        if (amount <= 50) {
            return 0;
        }
        int rewards = 0;

        if (amount > 100) {
            rewards += Math.floor(2 * (amount - 100) + 50);
        } else if (amount < 100) {
            rewards += Math.floor(amount - 50);
        }

        return rewards;
    }
}
