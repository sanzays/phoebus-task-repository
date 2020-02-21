package com.phoebus.assignment.endpoint;

import com.phoebus.assignment.dto.CustomerDTO;
import com.phoebus.assignment.entity.Account;
import com.phoebus.assignment.entity.Customer;
import com.phoebus.assignment.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired

    private ICustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public List<Account> lookUpCustomerUsingAccountId(@RequestParam(value = "customerId") String customerId) {
        return customerService.getAccountsForACustomerId(customerId);
    }

    @PostMapping(
            value = "/account", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Customer addAccountWithCustomer(@RequestBody CustomerDTO customerDTO) {

        return customerService.addCustomer(customerDTO);

    }
}
