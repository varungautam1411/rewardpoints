package com.customer.rewardpoints.model;

public class CustomerRewards {

	
	    public int customerId;



	public String customerName;
		public int lastMonthCustomerRewardPoints;
	    public int secondLastMothCustomerRewardPoints;
	    public int thirdLastMothCustomerRewardPoints;
	    public int totalCustomerRewardPoints;
	    
	    
	    public int getCustomerId() {
			return customerId;
		}
		public int getLastMonthCustomerRewardPoints() {
			return lastMonthCustomerRewardPoints;
		}
		public int getSecondLastMothCustomerRewardPoints() {
			return secondLastMothCustomerRewardPoints;
		}
		public int getThirdLastMothCustomerRewardPoints() {
			return thirdLastMothCustomerRewardPoints;
		}
		public int getTotalCustomerRewardPoints() {
			return totalCustomerRewardPoints;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public void setLastMonthCustomerRewardPoints(int lastMonthCustomerRewardPoints) {
			this.lastMonthCustomerRewardPoints = lastMonthCustomerRewardPoints;
		}
		public void setSecondLastMothCustomerRewardPoints(int secondLastMothCustomerRewardPoints) {
			this.secondLastMothCustomerRewardPoints = secondLastMothCustomerRewardPoints;
		}
		public void setThirdLastMothCustomerRewardPoints(int thirdLastMothCustomerRewardPoints) {
			this.thirdLastMothCustomerRewardPoints = thirdLastMothCustomerRewardPoints;
		}
		public void setTotalCustomerRewardPoints(int totalCustomerRewardPoints) {
			this.totalCustomerRewardPoints = totalCustomerRewardPoints;
		}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	    
	}
