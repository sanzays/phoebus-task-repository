package com.phoebus.assignment.service;

import com.phoebus.assignment.dto.CustomerDTO;
import com.phoebus.assignment.entity.Account;
import com.phoebus.assignment.entity.Customer;
import com.phoebus.assignment.repository.IAccountRepository;
import com.phoebus.assignment.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Account> getAccountsForACustomerId(String customerId) {

        return accountRepository.findByCustomers_customerId(customerId);
    }

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setForename(customerDTO.getForeName());
        customer.setSurname(customerDTO.getSurName());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        Account account = new Account();
        account.setAccountNumber(customerDTO.getAccountNumber());
        customer.getAccounts().add(account);

        return customerRepository.save(customer);
    }

}
