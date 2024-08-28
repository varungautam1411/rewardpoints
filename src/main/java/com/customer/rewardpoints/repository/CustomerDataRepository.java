package com.customer.rewardpoints.repository;

import org.springframework.data.repository.CrudRepository;

import com.customer.rewardpoints.entity.CustomerData;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDataRepository extends CrudRepository<CustomerData, Long> {
    public CustomerData findByCustomerId(int customerId);
}