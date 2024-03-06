package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.payload.IncomeExpenseComparison;
import com.banana.bananamint.persistence.AccountJPARepository;
import com.banana.bananamint.persistence.CustomerJPARepository;
import com.banana.bananamint.persistence.ExpenseJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class IncomeExpenseService implements IIncomeExpenseService {

    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private CustomerJPARepository customerRepo;

    @Autowired
    private AccountJPARepository accountRepo;

    @Autowired
    private ExpenseJPARepository expenseRepo;


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
        Customer newcustomer = customerRepo.findById(idCustomer).orElseThrow(() -> new CustomerException("Cliente inexistente. ID: " + idCustomer));
        Account newAccount = accountRepo.findById(expense.getMoneyFrom().getId()).orElseThrow(() -> new AccountException("Cuenta inexistente. ID: " + expense.getMoneyFrom().getId()));

        return expenseRepo.save(expense);
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
