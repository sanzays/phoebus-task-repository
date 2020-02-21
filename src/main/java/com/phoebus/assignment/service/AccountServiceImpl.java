package com.phoebus.assignment.service;

import com.phoebus.assignment.dto.AccountDTO;
import com.phoebus.assignment.entity.Account;
import com.phoebus.assignment.entity.Customer;
import com.phoebus.assignment.repository.IAccountRepository;
import com.phoebus.assignment.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Customer> getCustomersForAnAccountNumber(Integer accountNumber){

        return customerRepository.findByAccounts_AccountNumber(accountNumber);
    }

    @Override
    public Account addAccount(AccountDTO accountDTO){

        Account account = new Account();
        account.setAccountNumber(accountDTO.getAccountNumber());

        return accountRepository.save(account);
    }
}
