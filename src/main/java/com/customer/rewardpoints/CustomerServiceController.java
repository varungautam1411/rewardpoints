package com.customer.rewardpoints;



import com.customer.rewardpoints.entity.CustomerTransactions;
import com.customer.rewardpoints.exception.NoTransactionMadeException;
import com.customer.rewardpoints.exception.RewardsExceptions;
import com.customer.rewardpoints.service.CustomerRewardsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewardpoints.entity.CustomerData;
import com.customer.rewardpoints.model.CustomerRewards;
import com.customer.rewardpoints.repository.CustomerDataRepository;
import com.customer.rewardpoints.repository.CustomerTransactionsRepository;

import java.util.List;


@RestController
@RequestMapping(
		"/customerRewards")

public class CustomerServiceController {

	@Autowired
	CustomerDataRepository customerDataRepository;
	@Autowired
	CustomerTransactionsRepository customerTransactionsRepository;
	
	@GetMapping(value = "/{customerID}")
	public ResponseEntity<CustomerRewards>  getCustomerRewardsById(@PathVariable int customerID)
	{
	CustomerData customerData = customerDataRepository.findByCustomerId(customerID);
	if(customerData == null)
	{
		throw new NoTransactionMadeException();
	}
	List<CustomerTransactions> list = customerTransactionsRepository.findAllByCustomerId(customerID);
	CustomerRewards customerRewards;
	CustomerRewardsServiceImpl customerRewardsService = new CustomerRewardsServiceImpl();
	customerRewards = customerRewardsService.prepareRewardsList(list);
	customerRewards.setCustomerName(customerData.getCustomerName());
	return new ResponseEntity<>(customerRewards,HttpStatus.OK);
	}
}


