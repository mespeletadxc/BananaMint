package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.persistence.AccountJPARepository;
import com.banana.bananamint.persistence.CustomerJPARepository;
import com.banana.bananamint.persistence.IncomeJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IncomeExpenseServiceTest {
//    @Autowired
//    private IncomeJPARepository incomeRepo;
    @Autowired
    private CustomerJPARepository customerRepo;
    @Autowired
    private AccountJPARepository accountRepo;

    @Autowired
    private IncomeExpenseService incomeService;
    @Test
    void addIncomeWithIdCustomer() {
        long idCustomer = 1L;
        //Account newAccount = accountRepo.findById(idCustomer);

        Customer newCustomer = customerRepo.findById(idCustomer).orElseThrow(() -> new CustomerException(idCustomer));
        Account newAccountAux = (Account) newCustomer.getAccounts();
        Account newAccount = accountRepo.findById(newAccountAux.getId()).orElseThrow(() -> new AccountException(idCustomer));

        Income newInc = new Income(null, null, 100.00, LocalDate.now(), newAccount, "ingreso");
        incomeService.addIncome(idCustomer,newInc);
    }
}