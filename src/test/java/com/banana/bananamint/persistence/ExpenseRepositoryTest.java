package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Autowired
    private CustomerJPARepository customerRepo;

    @Autowired
    private AccountJPARepository accountRepo;

    @Autowired
    private ExpenseJPARepository expenseRepo;

    @Test
    void addExpense() {
        Customer cus1 = new Customer(null, "Juan", "Pepe@hotmail.com", LocalDate.now(), "12345678L");
        Account acc1 = new Account(null, "Corriente", LocalDate.now(), 1000.00, 100.00,
                cus1, true);

        Expense newExp = new Expense(null, cus1, 10.00, LocalDate.now(), acc1, "estado del gasto");
//        Expense newExp = new Expense(null, customerRepo.findById(1L).get(), 10.00, LocalDate.now(), accountRepo.findById(1L).get(), "estado del gasto");


        expenseRepo.save(newExp);
        System.out.println("Nuevo gasto: " + newExp);

        assertThat(newExp.getId()).isGreaterThan(0);

    }

}