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


//    @GetMapping("")
//    public ResponseEntity getAccount() {
//        List<Account> accs = accountService.getAccounts();
//        if (accs != null && accs.size() > 0) return ResponseEntity.status(HttpStatus.OK).body(accs);
//        else throw new AccountNotfoundException("Lista vacia");
//    }

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

//    @GetMapping("/{id}")
//    public ResponseEntity<Account> getAccount(
//            @PathVariable @Min(1) Long id
//    ) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccount(id));
//        } catch (AccountNotfoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    // update account
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Account> updateAccount(
//            @RequestBody Account account,
//            @PathVariable @Min(1) Long id
//    ) {
//        account.setId(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.updateAccount(id, account));
//    }
//
//    // Add Money
//   /* @PutMapping("/addmoney/{id}")
//    public ResponseEntity<Account> addMoney(
//            @PathVariable Long id,
//            @RequestParam int amount,
//            @RequestParam Long ownerId
//    ) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.addBalance(id, amount, ownerId));
//    }*/
//
//    @PutMapping("/addmoney/{id}")
//    public ResponseEntity<Account> addMoney(
//            @PathVariable @Min(1) Long id,
//            @RequestBody @Valid MoneyForOwner moneyForOwner
//    ) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.addBalance(id, moneyForOwner.getAmount(), moneyForOwner.getOwnerId()));
//    }
//
//    // withdraw Money
//   /* @PutMapping("/withdraw/{id}")
//    public ResponseEntity<Account> withdraw(
//            @PathVariable Long id,
//            @RequestParam int amount,
//            @RequestParam Long ownerId
//    ) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.withdrawBalance(id, amount, ownerId));
//    }*/
//    @PutMapping("/withdraw/{id}")
//    public ResponseEntity<Account> withdraw(
//            @PathVariable @Min(1) Long id,
//            @RequestBody @Valid MoneyForOwner moneyForOwner
//    ) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.withdrawBalance
//                (id, moneyForOwner.getAmount(), moneyForOwner.getOwnerId()));
//    }
//
//    // Delete Account
//    /*@DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public ApiResponse deleteAccount(
//            @PathVariable Long id
//    ) {
//        this.accountService.delete(id);
//        return new ApiResponse("Account is Successfully Deleted", true);
//    }*/
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteAccount(
//            @PathVariable @Min(1) Long id
//    ) {
//        this.accountService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Delete Account using ownerId
//
//    /*@DeleteMapping("user/{ownerId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public ApiResponse deleteAccountByUserId(
//            @PathVariable Long ownerId
//    ) {
//        this.accountService.deleteAccountsUsingOwnerId(ownerId);
//        return new ApiResponse(" Accounts with given userId is deleted Successfully", true);
//
//    }*/
//
//    @DeleteMapping("user/{ownerId}")
//    public ResponseEntity deleteAccountByUserId(
//            @PathVariable @Min(1) Long ownerId
//    ) {
//        this.accountService.deleteAccountsUsingOwnerId(ownerId);
//        return ResponseEntity.noContent().build();
//
//    }
}
