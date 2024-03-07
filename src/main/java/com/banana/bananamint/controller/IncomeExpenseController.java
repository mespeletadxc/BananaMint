package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.persistence.AccountJPARepository;
import com.banana.bananamint.persistence.CustomerJPARepository;
import com.banana.bananamint.persistence.ExpenseJPARepository;
import com.banana.bananamint.services.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Optional;

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


    @PostMapping(value = "/customer/{cid}/account/{aid}/addexpense", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addExpense(
            @PathVariable @Min(1) Long cid,
            @PathVariable @Min(1) Long aid,
            @RequestBody @Valid Expense expense
    ) {
//        System.out.println("entro en addExpense");
//
//        Customer newCustomer = customerRepo.findById(cid).orElseThrow(() -> new CustomerException("Cliente inexistente. ID: " + cid));
//
//         Account newAccount = accountRepo.findById(aid).orElseThrow(() -> new AccountException("Cuenta inexistente. ID: " + aid));


//        Expense newExpense = new Expense(null, customerRepo.findById(cid).get(), expense.getAmount(), expense.getDueDate(), accountRepo.findById(aid).get(), expense.getStatus());

//        Expense newExpense = new Expense(null, customerRepo.findById(1L).get(), 200.00, LocalDate.now(), accountRepo.findById(1L).get(), "estado");

//        System.out.println(newExpense);
//        expenseService.addExpense(cid, newExpense);
//        System.out.println("fin en addExpense");

//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(expenseService.addExpense(cid, newExpense));
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(expenseService.addExpense(cid, new Expense(null, customerRepo.findById(cid).get(), expense.getAmount(), expense.getDueDate(), accountRepo.findById(aid).get(), expense.getStatus())));
//        return null;
        } catch (IncomeExpenseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();
        }
    }
        @GetMapping("/maria")
        public void hola (

                ) {
            System.out.println("hola");

        }

    }
