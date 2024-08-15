package com.customer.rewardpoints.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.customer.rewardpoints.entity.CustomerTransactions;
import com.customer.rewardpoints.model.CustomerRewards;
import com.customer.rewardpoints.repository.CustomerTransactionsRepository;
@Service
public class CustomerRewardsServiceImpl {
	
	@Autowired
	CustomerTransactionsRepository customerTransactionsRepository;
	
	
	public CustomerRewards prepareRewardsList(List<CustomerTransactions> list) {

	

		List<CustomerTransactions> totalTransactions = list;
		CustomerRewards customerRewards = new CustomerRewards();
		customerRewards.setCustomerId(totalTransactions.get(0).getCustomerId());
		for(CustomerTransactions customerTransactions : list){

			Date dateTemp = customerTransactions.getTransDate();
			System.out.println("dateTemp" +dateTemp);
			int month = dateTemp.getMonth()+1;
			System.out.println("month" +month);

			GregorianCalendar date = new GregorianCalendar();
			int currentMonth = date.get(Calendar.MONTH)+1;
			int rewards = calculateReward(customerTransactions.getAmount());
			System.out.println("month" +month);
			System.out.println("currentMonth" +currentMonth);
			if(currentMonth - month == 1){
				customerRewards.setLastMonthCustomerRewardPoints(customerRewards.getLastMonthCustomerRewardPoints()+rewards);
				customerRewards.setTotalCustomerRewardPoints(customerRewards.getTotalCustomerRewardPoints()+rewards);

			}else if(currentMonth - month == 2){
				customerRewards.setSecondLastMothCustomerRewardPoints(customerRewards.getSecondLastMothCustomerRewardPoints()+rewards);
				customerRewards.setTotalCustomerRewardPoints(customerRewards.getTotalCustomerRewardPoints()+rewards);
			}else if(currentMonth - month == 3){
				customerRewards.setThirdLastMothCustomerRewardPoints(customerRewards.getThirdLastMothCustomerRewardPoints()+rewards);
				customerRewards.setTotalCustomerRewardPoints(customerRewards.getTotalCustomerRewardPoints()+rewards);
			}


		}


//		Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
//		Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
//		Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);
//
//		Rewards customerRewards = new Rewards();
//		customerRewards.setCustomerId(customerId);
//		customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
//		customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
//		customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
//		customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;

	}

	public int calculateReward(int amount){

		if(amount <=50){
			return 0;
		}
		int rewards =0;

			if(amount > 100){
				rewards+=2*(amount-100) + 50;
			}else if(amount < 100 ){
				rewards+=amount-50;
			}

			return rewards;
	}
}
