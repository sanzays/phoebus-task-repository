package com.phoebus.assignment.repository;

import com.phoebus.assignment.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IAccountRepository extends JpaRepository <Account, String> {

     public List<Account> findByCustomers_customerId(String customerId);

     public Account save(Account account);

     @Query("SELECT acc FROM Account acc  WHERE acc.accountNumber=(:accountNumber)")
     public Account findByAccountNumber(Integer accountNumber);
}
