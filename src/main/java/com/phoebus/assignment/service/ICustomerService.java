package com.phoebus.assignment.service;

import com.phoebus.assignment.dto.CustomerDTO;
import com.phoebus.assignment.entity.Account;
import com.phoebus.assignment.entity.Customer;

import java.util.List;

public interface ICustomerService {

    public List<Account> getAccountsForACustomerId(String customerId);

    public Customer addCustomer(CustomerDTO customerDTO);
}
