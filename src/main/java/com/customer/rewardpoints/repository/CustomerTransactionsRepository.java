package com.customer.rewardpoints.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.customer.rewardpoints.entity.CustomerTransactions;

@Repository
public interface CustomerTransactionsRepository extends CrudRepository<CustomerTransactions, Long> {
    public List<CustomerTransactions> findAllByCustomerId(int customerId);


}