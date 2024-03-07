/*package com.banana.bananamint.services;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.exception.BudgetException;

import com.banana.bananamint.persistence.BudgetJPARepository;
import com.banana.bananamint.persistence.CustomerJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService_old implements IBudgetService {
    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private BudgetJPARepository budgetRepository;

    @Autowired
    private CustomerJPARepository customerRepository;

    @Override
    public List<Budget> showAll(Long idCustomer, String categoryName) throws BudgetException {
        return budgetRepository.findAll();
        *//*return null;*//*
    }

    @Override
    public Budget add(Long idCustomer, String categoryName) throws BudgetException {
        return null;
    }

}*/