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

//    @Override
//    public List<Account> getAccounts() {
//        return accountRepository.findAll();
//    }
//
//    @Override
//    public Account getAccount(Long id) {
//        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
//        Customer owner = null; // Will be gotten from user service
//        account.setOwner(owner);
//        return account;
//    }
//
//    @Override
//    public List<Account> getAccountByOwnerId(Long ownerId) {
//        return accountJPARepository.findByOwnerId(ownerId);
//    }
//
//    @Override
//    public Account updateAccount(Long id, Account account) {
//        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
//        newAccount.setType(account.getType());
//        return accountRepository.save(newAccount);
//    }
//
//    @Override
//    public Account addBalance(Long id, int amount, Long ownerId) {
//        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
//        Customer owner = null;// Will be gotten from user service
//        int newBalance = newAccount.getBalance() + amount;
//        newAccount.setBalance(newBalance);
//        return accountRepository.save(newAccount);
//    }
//
//    @Override
//    public Account withdrawBalance(Long id, int amount, Long ownerId) {
//        Account newAccount = accountRepository.findById(id).orElseThrow(() ->
//                new AccountNotfoundException(id));
//        Customer owner = null; // Will be gotten from user service
//        int newBalance = newAccount.getBalance() - amount;
//        newAccount.setBalance(newBalance);
//        return accountRepository.save(newAccount);
//    }
//
//    @Override
//    public void delete(Long id) {
//        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
//        this.accountRepository.delete(account);
//    }
//
//    @Override
//    public void deleteAccountsUsingOwnerId(Long ownerId) {
//        List<Account> accounts = accountRepository.findByOwnerId(ownerId);
//        if (accounts != null && accounts.size() > 0) {
//            for (Account account : accounts) {
//                this.accountRepository.delete(account);
//            }
//        } else throw new AccountNotfoundException("No accoutns for:"+ownerId);
//    }


}
