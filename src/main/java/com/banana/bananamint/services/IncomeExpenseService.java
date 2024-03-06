package com.banana.bananamint.services;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.payload.IncomeExpenseComparison;

import java.time.LocalDate;
import java.util.List;

public class IncomeExpenseService implements IIncomeExpenseService{


    @Override
    public List<Income> showAllIncomes(Long idCustomer) throws IncomeExpenseException {
        return null;
    }

    @Override
    public Income addIncome(Long idCustomer, Income income) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<Expense> showAllExpenses(Long idCustomer) throws IncomeExpenseException {
        return null;
    }

    @Override
    public Expense addExpense(Long idCustomer, Expense expense) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<Expense> showAllExpensesByDateRange(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<IncomeExpenseComparison> getFinancialPerspective(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }
}
