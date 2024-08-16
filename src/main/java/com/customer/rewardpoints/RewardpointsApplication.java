package com.customer.rewardpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RewardpointsApplication {
	private static final Logger logger = LoggerFactory.getLogger(RewardpointsApplication.class);
	public static void main(String[] args) {
		logger.info("Starting the application");
		SpringApplication.run(RewardpointsApplication.class, args);
	}


}
