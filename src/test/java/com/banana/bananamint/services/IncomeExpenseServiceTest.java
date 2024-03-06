package com.banana.bananamint.services;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Account;


import com.banana.bananamint.persistence.AccountJPARepository;
import com.banana.bananamint.persistence.CustomerJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class IncomeExpenseServiceTest {
    @Autowired
    private IncomeExpenseService service;

    @Autowired
    private CustomerJPARepository customerRepo;
    @Autowired
    private AccountJPARepository accountRepo;

    @Test
    void addExpenseWithCustomerId() {
        Long idCustomer = 1L;
        Expense newExpense = new Expense(null, customerRepo.findById(idCustomer).get(), 100.0, LocalDate.now(), accountRepo.findById(1L).get(), "estado");

        service.addExpense(idCustomer, newExpense);
        System.out.println("Nuevo gasto. ID: " + newExpense);
    }

}
