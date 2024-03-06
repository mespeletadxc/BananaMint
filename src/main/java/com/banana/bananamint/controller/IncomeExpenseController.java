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
import java.time.LocalDate;

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


    @PostMapping("/customer/{cid}/account/{aid}/addexpense")
//    @PostMapping("/customer/1/account/1/addexpense")
//    @PostMapping("/addexpense")
    public ResponseEntity addExpense(
            @PathVariable @Min(1) Long cid,
            @PathVariable @Min(1) Long aid,
            @RequestBody @Valid Expense expense
    ) {
        Account newAccount = accountRepo.findById(1L).orElseThrow(() -> new AccountException("Cuenta inexistente. ID: " + 1L));

        Expense newExpense = new Expense(null, customerRepo.findById(1L).get(), expense.getAmount(), expense.getDueDate(), accountRepo.findById(1L).get(), expense.getStatus());
//        Expense newExpense = new Expense(null, customerRepo.findById(1L).get(), 200.00, LocalDate.now(), accountRepo.findById(1L).get(), "estado");

//        System.out.println(newExpense);
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.addExpense(1L, newExpense));
    }
    @GetMapping("/maria")
    public void hola(

    ){
        System.out.println("hola");

    }

}
