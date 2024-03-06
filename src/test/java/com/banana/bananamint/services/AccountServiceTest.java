package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    private IAccountService service;

    @Test
    void open() {
        Account newAcc = new Account(null, "ctaservice", LocalDate.now(), 1000.00, 100.00,
                null, true);

        service.open(5L, newAcc);
        List<Account> accounts = service.showAll(5L);

        assertThat(accounts.size()).isGreaterThan(0);
    }

    @Test
    void dadoAccountNOValido_cuandoCrear_entoncesExcepcion() {

            assertThrows(NullPointerException.class, () -> {
            //Account null
            service.open(6L, null);


        });
    }
}