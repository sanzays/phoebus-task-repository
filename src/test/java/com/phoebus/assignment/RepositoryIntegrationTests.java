package com.phoebus.assignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.phoebus.assignment.entity.Account;
import com.phoebus.assignment.entity.Customer;
import com.phoebus.assignment.repository.IAccountRepository;
import com.phoebus.assignment.repository.ICustomerRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


//@SpringBootTest(classes = {AccountRepository.class, CustomerRepository.class})

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@EnableJpaRepositories("com.phoebus.assignment.repository")
@EntityScan("com.phoebus.assignment.entity")
@ContextConfiguration(classes = {ObjectMapper.class})

class RepositoryIntegrationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private ICustomerRepository customerRepository;

	@Test
	void testAccountAndCustomerRepositories(){

		Account account = new Account();
		account.setAccountNumber(123);

		Customer customer = new Customer();
		customer.setForename("Sanjay");
		customer.setSurname("Jay");
		LocalDate ldObj = LocalDate.of(1980, 11, 6);
		customer.setDateOfBirth(ldObj);
		account.getCustomers().add(customer);

		customer.getAccounts().add(account);

		accountRepository.save(account);

		customerRepository.save(customer);

		Account byAccountNumber = accountRepository.findByAccountNumber(123);

		final Set<Customer> customers = byAccountNumber.getCustomers();

		Assert.isTrue(byAccountNumber.getAccountNumber()==123, "Fetched account number");

		Assert.isTrue(customers.stream().anyMatch(cust -> cust.getForename().equals("Sanjay")), "Fetched account number");

		List<Customer> customersByAccountNumber = customerRepository.findByAccounts_AccountNumber(123);

		Assert.isTrue(byAccountNumber.getAccountNumber()==123, "Fetched account number");

		Assert.isTrue(customersByAccountNumber.stream().anyMatch(cust -> cust.getForename().equals("Sanjay")), "Fetched account number");

	}



}
