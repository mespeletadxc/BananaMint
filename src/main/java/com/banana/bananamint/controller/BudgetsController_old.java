/*package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.services.BudgetService_old;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/budgets")
@Validated
public class BudgetsController_old {

    @Autowired
    private BudgetService_old budgetService;


    @GetMapping("/{id}/{name}")
    public ResponseEntity<Budget> showAllBudges(
            @PathVariable @Min(1) Long id, @PathVariable @NotBlank String name
    ) {
        return ResponseEntity.status(HttpStatus.OK).body((Budget) budgetService.showAll(id, name));
        *//*return ResponseEntity.status(HttpStatus.OK).body(budgetService.showAll(id,name));*//*
    }

}*/
