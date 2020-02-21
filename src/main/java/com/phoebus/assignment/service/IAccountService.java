package com.phoebus.assignment.service;

import com.phoebus.assignment.dto.AccountDTO;
import com.phoebus.assignment.entity.Account;
import com.phoebus.assignment.entity.Customer;

import java.util.List;

public interface IAccountService {

    public List<Customer> getCustomersForAnAccountNumber(Integer accountNumber);

    public Account addAccount(AccountDTO accountDTO);
}
