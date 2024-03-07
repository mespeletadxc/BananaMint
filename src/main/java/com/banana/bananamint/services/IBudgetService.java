package com.banana.bananamint.services;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.exception.BudgetException;

import java.sql.SQLException;
import java.util.List;

public interface IBudgetService {
    public List<Budget> showAll(Long idCustomer, String categoryName) throws BudgetException;

    public Budget add(Long idCustomer, String categoryName) throws BudgetException;
}
