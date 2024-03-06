package com.banana.bananamint.services;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.payload.IncomeExpenseComparison;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.IncomeExpenseException;

import java.time.LocalDate;
import java.util.List;

public interface IIncomeExpenseService {
    public List<Income> showAllIncomes(Long idCustomer) throws IncomeExpenseException;

    public Income addIncome(Long idCustomer, Income income) throws IncomeExpenseException;

//    public List<Income> showAllExpenses(Long idCustomer) throws IncomeExpenseException;
    public List<Expense> showAllExpenses(Long idCustomer) throws IncomeExpenseException;

//    public Income addExpense(Long idCustomer, Income income) throws IncomeExpenseException;
    public Expense addExpense(Long idCustomer, Expense expense) throws IncomeExpenseException;

//    public List<Income> showAllExpensesByDateRange(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException;
    public List<Expense> showAllExpensesByDateRange(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException;

    public List<IncomeExpenseComparison> getFinancialPerspective(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException;

}