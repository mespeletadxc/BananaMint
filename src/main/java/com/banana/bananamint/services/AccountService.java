package com.banana.bananamint.services;


import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountJPARepository accountJPARepository;

    @Autowired
    private CustomerJPARepository customerJPARepository;

    @Override
    public Account open(Long idCustomer, Account account) {

        //Customer aCustomer = customerJPARepository.getReferenceById(idCustomer);
        Customer aCustomer = new Customer(idCustomer);
        account.setOwner(aCustomer);

        return accountJPARepository.save(account);

    }


    @Override
    public List<Account> showAll(Long IdCustomer) {
        List<Account> accounts = accountJPARepository.findByOwnerId(IdCustomer);

//        List<Account> allAccounts = accountJPARepository.findAll();

        return accounts;
    }




}
