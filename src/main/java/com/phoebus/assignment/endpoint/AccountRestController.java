package com.phoebus.assignment.endpoint;

import com.phoebus.assignment.entity.Customer;
import com.phoebus.assignment.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/accounts/{accountNumber}")
    public List<Customer> lookUpAccountUsingCustomerId(@RequestParam(value = "accountNumber") Integer accountNumber) {
        return accountService.getCustomersForAnAccountNumber(accountNumber);
    }


}
