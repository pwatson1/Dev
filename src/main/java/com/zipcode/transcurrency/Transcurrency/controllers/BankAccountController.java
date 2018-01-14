package com.zipcode.transcurrency.Transcurrency.controllers;


import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController() {

    }

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    //gets all bank accounts
//    @RequestMapping(value = "/bankAccounts", method = RequestMethod.GET)
//    public ResponseEntity<Iterable<BankAccount>> getAllBankAccounts() {
//        return bankAccountService.getAllBankAccounts();
//    }

    @RequestMapping(value = "/bankAccounts", method = RequestMethod.GET)
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    //creates a bank account object
    @RequestMapping(value = "/bankAccounts", method = RequestMethod.POST)
    public ResponseEntity<?> createBankAccount(@RequestBody BankAccount bankAccount){
        return bankAccountService.createBankAccount(bankAccount);
    }

    //get a bank account
    @RequestMapping(value = "/bankAccounts/{bankAccountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBankAccount(@PathVariable Long bankAccountId){
        return bankAccountService.getBankAccount(bankAccountId);
    }

    //update a bank account
    @RequestMapping(value = "/bankAccounts/{bankAccountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Long bankAccountId){
        return bankAccountService.updateBankAccount(bankAccount, bankAccountId);
    }

    //delete a bank account
    @RequestMapping(value = "/bankAccounts/{bankAccountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBankAccount(@PathVariable Long bankAccountId){
        return bankAccountService.deleteBankAccount(bankAccountId);
    }

}
