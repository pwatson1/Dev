package com.zipcode.transcurrency.Transcurrency.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.repositories.BankAccountRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


@Service
public class BankAccountService {
    private static final Logger logger = LogManager.getLogger(BankAccountService.class);

    private BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public ResponseEntity<Iterable<BankAccount>> getAllBankAccounts() {
        logger.info("Retrieving all bankAccounts.");
        Iterable<BankAccount> allBankAccounts = bankAccountRepository.findAll();
        return new ResponseEntity<>(allBankAccounts, HttpStatus.OK);
    }

    public ResponseEntity<?> createBankAccount(BankAccount bankAccount) {
        logger.info("New bankAccount generated.");
        bankAccount = bankAccountRepository.save(bankAccount);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBankAccountURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{bankAccountId}")
                .buildAndExpand(bankAccount.getBankAccountId())
                .toUri();
        responseHeaders.setLocation(newBankAccountURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getBankAccount(Long bankAccountId){
        logger.info("BankAccount retrieved.");
        BankAccount bankAccount = bankAccountRepository.findOne(bankAccountId);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    public ResponseEntity<?> updateBankAccount(BankAccount bankAccount, Long bankAccountId){
        logger.info("BankAccount info modified.");
        BankAccount account = bankAccountRepository.save(bankAccount);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteBankAccount(Long bankAccountId){
        logger.info("BankAccount deleted.");
        bankAccountRepository.delete(bankAccountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
