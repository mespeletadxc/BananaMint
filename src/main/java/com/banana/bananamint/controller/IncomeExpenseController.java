package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.persistence.AccountJPARepository;
import com.banana.bananamint.persistence.CustomerJPARepository;
import com.banana.bananamint.persistence.ExpenseJPARepository;
import com.banana.bananamint.services.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
//@RequestMapping("/expense")
@Validated
public class IncomeExpenseController {

    @Autowired
    private CustomerJPARepository customerRepo;

    @Autowired
    private AccountJPARepository accountRepo;

    @Autowired
    private IncomeExpenseService expenseService;

//    @PutMapping("/addexpense/{idcustomer}/{idaccount}")
    @PutMapping("/customer/{cid}/account/{aid}/addexpense")
    public ResponseEntity addExpense(
            @PathVariable @Min(1) Long cid,
            @PathVariable @Min(1) Long aid,
            @RequestBody @Valid Expense expense
    ) {
        Account newAccount = accountRepo.findById(aid).orElseThrow(() -> new AccountException("Cuenta inexistente. ID: " + aid));

        Expense newExpense = new Expense(null, customerRepo.findById(cid).get(), expense.getAmount(), expense.getDueDate(), accountRepo.findById(aid).get(), expense.getStatus());

        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.addExpense(cid, newExpense));
    }

}
