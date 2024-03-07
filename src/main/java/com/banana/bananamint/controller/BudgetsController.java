/*package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.domain.StatusMessage;
import com.banana.bananamint.exception.BudgetException;
import com.banana.bananamint.persistence.CustomerJPARepository;
import com.banana.bananamint.persistence.JPABudgetJPARepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/budgets")
@Validated
@Tag(name = "Budgets API", description = "Finanzas management APIs")
public class BudgetsController {
    private static final Logger logger = LoggerFactory.getLogger(BudgetsController.class);

    @Autowired
    private JPABudgetJPARepository repo;

    @Autowired
    private CustomerJPARepository customerRepository;

    *//*******************************************************//*
    *//*@GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Budget>> muestraTodos() throws SQLException {
        if (repo.findAll().size() > 0) {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        } else {
            throw new BudgetException("La lista de budgets está vacía");
        }
    }*//*

    @GetMapping(value = "/{pid}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity actualizaProyecto(
            @PathVariable("pid") @Min(1) Long id,
            @RequestBody @Valid Budget aBudget
    ) throws SQLException {
        if (id == aBudget.getId()) {
            return new ResponseEntity<>(repo.findAll(id), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(new StatusMessage(HttpStatus.PRECONDITION_FAILED.value(), "Id y budget.id deben coincidir"), HttpStatus.PRECONDITION_FAILED);
        }
    }

    *//*******************************************************//*

    @Operation(summary = "Add a new budget", description = "Returns a persisted budget")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Successfully created"),
            @ApiResponse(responseCode = "4XX", description = "Bad request")
    })
    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity guardaBudget(
            @RequestBody @Valid Budget newBudget
    ) throws SQLException {
        logger.info("newBudget:" + newBudget);
        newBudget.setId(null);
        return new ResponseEntity<>(repo.save(newBudget), HttpStatus.CREATED);
    }

}*/
