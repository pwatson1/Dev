package com.zipcode.transcurrency.Transcurrency.controllers;


import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.services.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BankAccountController {
    private final Logger LOG = LoggerFactory.getLogger(BankAccountController.class);

    private BankAccountService bankAccountService;

    public BankAccountController() {

    }

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    //gets all bank accounts
    @RequestMapping(value = "/bankAccounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<BankAccount>> getAllBankAccounts() {
        LOG.info("gets all bank accounts");
        return bankAccountService.getAllBankAccounts();
    }

    //creates a bank account object
    @RequestMapping(value = "/bankAccounts", method = RequestMethod.POST)
    public ResponseEntity<?> createBankAccount(@RequestBody BankAccount bankAccount){
        LOG.info("creates a bank account object");
        return bankAccountService.createBankAccount(bankAccount);
    }

    //getTransaction a bank account
    @RequestMapping(value = "/bankAccounts/{bankAccountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBankAccount(@PathVariable Long bankAccountId){
        LOG.info("get a bank account");
        return bankAccountService.getBankAccount(bankAccountId);
    }

    //updateTransaction a bank account
    @RequestMapping(value = "/bankAccounts/{bankAccountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Long bankAccountId){
        LOG.info("update a bank account");
        return bankAccountService.updateBankAccount(bankAccount, bankAccountId);
    }

    //deleteTransaction a bank account
    @RequestMapping(value = "/bankAccounts/{bankAccountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBankAccount(@PathVariable Long bankAccountId){
        LOG.info("delete a bank account");
        return bankAccountService.deleteBankAccount(bankAccountId);
    }

}
