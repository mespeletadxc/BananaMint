package com.banana.bananamint.Controller;


import com.banana.bananamint.domain.Account;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.exception.AccountNotfoundException;
import com.banana.bananamint.persistence.AccountJPARepository;
import com.banana.bananamint.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import java.util.List;

@RestController
@RequestMapping("/accounts")
@Validated
@Tag(name = "Accounts API", description = "Accounts management APIs")
public class AccountsController {
    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountJPARepository accountJPARepository;


    @Operation(summary = "Add a new Account", description = "Returns a persisted Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201A", description = "Successfully created"),
            @ApiResponse(responseCode = "4XX", description = "Bad request")
    })
    @PostMapping(value = "/{idCustomer}", consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Account> createAccount(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Account data")
            @RequestBody @Valid Account account,
            @Parameter(name = "id", description = "Customer id", example = "1") @PathVariable @Min(1) Long idCustomer
    ) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(accountService.open(idCustomer, account));
        } catch (AccountException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();
        }

    }

@GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Account>> getAll() {
        List<Account> accounts = accountJPARepository.findAll();
        if (accounts != null && !accounts.isEmpty()) return ResponseEntity.status(HttpStatus.OK).body(accounts);
        else throw new AccountNotfoundException("No hay cuentas");
    }


}
