package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AccountRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Autowired
    private AccountJPARepository jpaRepo;

    //Test pasado OK para relación bidireccional (la dejo unidireccional por simplicidad)
//    @Test
//    void dadoAccountCustomerValidos_cuandoCrear_entonces_OK() {
//        Account newAcc = new Account(null, "Corriente", LocalDate.now(), 1000.00, 100.00,
//                new Customer(null, "Juan", "Juan@hotmail.com", LocalDate.now(), "12345678L", null), true);
//
//        jpaRepo.save(newAcc);
//        Optional<Account> aAccount = jpaRepo.findById(newAcc.getId());
//        System.out.println("Account: " + aAccount.toString());
//
//        assertEquals(aAccount.get().getId(), newAcc.getId());
//    }

    @Test
    void dadoAccountCustomerValidos_cuandoCrear_entonces_OK() {
        Customer customer = new Customer(50L);
        Account newAcc = new Account(null, "Corriente", LocalDate.now(), 1000.00, 100.00,
                customer, true);

        jpaRepo.save(newAcc);
        System.out.println("new Id:"+newAcc.getId());
        Account aAccount = jpaRepo.getReferenceById(newAcc.getId());

        assertEquals(aAccount.getId(), newAcc.getId());
    }


    @Test
    void dadoAccountNOValido_cuandoCrear_entoncesExcepcion() {

            assertThrows(InvalidDataAccessApiUsageException.class, ()-> {
            // Customer null
            Customer customer = new Customer(null);
            Account newAcc = new Account(null, "Corriente", LocalDate.now(), 1000.00, 100.00,
                    customer, true);
            jpaRepo.save(newAcc);

        });

    }


}