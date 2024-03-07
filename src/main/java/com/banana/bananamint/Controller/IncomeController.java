package com.banana.bananamint.Controller;

import com.banana.bananamint.persistence.IncomeJPARepository;
import com.banana.bananamint.services.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incomes")
@Validated
public class IncomeController {

    @Autowired
    private IncomeExpenseService incomeService;

    @Autowired
    private IncomeJPARepository incomeRepo;


}
