package com.banana.bananamint.Controller;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.persistence.CustomerJPARepository;
import com.banana.bananamint.persistence.IncomeJPARepository;
import com.banana.bananamint.services.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/incomes")
@Validated
public class IncomeController {

    @Autowired
    private IncomeExpenseService incomeService;

    @Autowired
    private IncomeJPARepository incomeRepo;
    @Autowired
    private CustomerJPARepository customerRepo;

    @GetMapping("")
    public ResponseEntity getIncome() {
        //List<Income> incomes = incomeRepo.getIncomes();
        List<Income> incomes = incomeRepo.findAll();
        if (incomes != null && incomes.size() > 0) return ResponseEntity.status(HttpStatus.OK).body(incomes);
        else {
            throw new IncomeExpenseException("Lista incomes vacia");
        }
    }

    @GetMapping("/customer")
    public ResponseEntity getCustomer() {
        //List<Income> incomes = incomeRepo.getIncomes();
        List<Customer> customers = customerRepo.findAll();
        if (customers != null && customers.size() > 0) return ResponseEntity.status(HttpStatus.OK).body(customers);
        else {
            throw new CustomerException("Lista customers vacia");
        }
    }

    @PostMapping("/{idcustomer}/{idaccount}")
    public ResponseEntity<Income> createIncome(
            @RequestBody @Valid Income income
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(incomeRepo.save(income));
    }
}
