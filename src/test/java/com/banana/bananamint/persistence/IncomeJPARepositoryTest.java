package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.AccessControlContext;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IncomeJPARepositoryTest {
     private static final Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Autowired
    private IncomeJPARepository jpaRepo;
    @Autowired
    private CustomerJPARepository jpaCustomerRepo;
    @Autowired
    private AccountJPARepository jpaAccountsRepo;

    @Test
    //@Transactional
    void addIncomeWithCustomerAndAccount() {

        Customer varCustomer = new Customer(null, "Maria", "Maria@maria.com", LocalDate.now(),"12345678L",null);
        //jpaCustomerRepo.save(varCustomer);
        Account varAccount = new Account(null, "Corriente", LocalDate.now(), 10.00, 1000.00,varCustomer, true);
        jpaAccountsRepo.save(varAccount);
        //Optional<Customer> varCustomer = jpaCustomerRepo.findById(1L);
        //Optional<Account> varAccount = jpaAccountsRepo.findById(2L);

       // Income newInc = new Income(null, varCustomer, 100.00, LocalDate.now(), varAccount, "ingresado");
        Income newInc = new Income(null, varCustomer, 100.00, LocalDate.now(), varAccount, "ingresado");

//        Income newInc = new Income(null, "Maria", "Maria@maria.com", LocalDate.now(),"12345678L",null);
//                new Customer(null, "Maria", "Maria@maria.com", LocalDate.now(),"12345678L",null),
//                100.00, LocalDate.now(),
//                new Account(null, "Corriente", LocalDate.now(), 10.00, 1000.00, true),"ingreso");

        jpaRepo.save(newInc);
        Optional<Income> opIncome = jpaRepo.findById(newInc.getId());
        //System.out.println("Account: "+aAccount.toString());

        assertEquals(opIncome.get().getId(), newInc.getId());
        // assertThat(aAccount.getId()).isGreaterThan(0);
    }
}