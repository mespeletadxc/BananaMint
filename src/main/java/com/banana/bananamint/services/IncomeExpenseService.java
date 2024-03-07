package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.payload.IncomeExpenseComparison;
import com.banana.bananamint.persistence.AccountJPARepository;
import com.banana.bananamint.persistence.CustomerJPARepository;
import com.banana.bananamint.persistence.IncomeJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeExpenseService implements IIncomeExpenseService{

    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private IncomeJPARepository incomeRepo;
    @Autowired
    private CustomerJPARepository customerRepo;
    @Autowired
    private AccountJPARepository accountRepo;


    @Override
    public List<Income> showAllIncomes(Long idCustomer) throws IncomeExpenseException {
        return null;
    }

    @Override
    public Income addIncome(Long idCustomer, Income income) throws IncomeExpenseException {

        Customer newCustomer = customerRepo.findById(idCustomer).orElseThrow(() -> new CustomerException(idCustomer));
        income.setUser(newCustomer);
        //Account newAccount = accountRepo.findById(newCustomer.getAccounts().get(0).getId()).orElseThrow(() -> new AccountException(income.getMoneyTo().getId()));
        //income.setMoneyTo(newAccount);

//        var newAccountAuxList = (List<Account>)newCustomer.getAccounts();
//
//        Account newAccount = newAccountAuxList.get(0);
//        income.setMoneyTo(newAccount);
        Account newAccount = accountRepo.findById(income.getMoneyTo().getId()).orElseThrow(() -> new AccountException(income.getMoneyTo().getId()));

        return incomeRepo.save(income);

    }

    @Override
    public List<Income> showAllExpenses(Long idCustomer) throws IncomeExpenseException {
        return null;
    }

    @Override
    public Income addExpense(Long idCustomer, Income income) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<Income> showAllExpensesByDateRange(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<IncomeExpenseComparison> getFinancialPerspective(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }
}
