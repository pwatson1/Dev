package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.repositories.BankAccountRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;



    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccountRepository.findAll()
                .forEach(bankAccounts::add);
        return bankAccounts;
    }

    public HttpHeaders createBankAccount(BankAccount bankAccount) {

        bankAccount = bankAccountRepository.save(bankAccount);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBankAccountURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{bankAccountId}")
                .buildAndExpand(bankAccount.getBankAccountId())
                .toUri();
        responseHeaders.setLocation(newBankAccountURI);

        return responseHeaders;
    }

    public BankAccount getBankAccount(Long bankAccountId){
        return bankAccountRepository.findOne(bankAccountId);
    }

    public BankAccount updateBankAccount(BankAccount bankAccount, Long bankAccountId){
        return bankAccountRepository.save(bankAccount);
    }

    public boolean deleteBankAccount(Long bankAccountId){
        bankAccountRepository.delete(bankAccountId);
        return true;
    }

}
