package com.phoebus.assignment.repository;

import com.phoebus.assignment.entity.Account;
import com.phoebus.assignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository <Customer, String> {

    public List<Customer> findByAccounts_AccountNumber(Integer accountNumber);

}
