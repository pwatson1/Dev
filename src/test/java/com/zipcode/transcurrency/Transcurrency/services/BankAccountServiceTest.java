package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.repositories.BankAccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BankAccountServiceTest {

    private BankAccountService bankAccountService;

    @Mock
    private BankAccountRepository bankAccountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bankAccountService = new BankAccountService(bankAccountRepository);
    }

    @Test
    public void getAllBankAccounts() {

        BankAccount bankAccount = new BankAccount();
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccount);

        when(bankAccountRepository.findAll()).thenReturn(bankAccountList);

        List<BankAccount> bankAccountTest = bankAccountService.getAllBankAccounts();

        verify(bankAccountRepository, times(1)).findAll();
        assertEquals(bankAccountList.size(), 1);
    }

    @Test(expected = RuntimeException.class)
    public void createBankAccount() throws Exception {

        when(bankAccountRepository.save(any(BankAccount.class))).thenThrow(RuntimeException.class);

        BankAccount bankAccountTest = new BankAccount();

        bankAccountService.createBankAccount(bankAccountTest);

        verify(bankAccountRepository, times(1)).save(bankAccountTest);
        verify(bankAccountRepository).save(any(BankAccount.class));

    }

    @Test
    public void getBankAccount() {

        //Given
        Long bankAccountId = 1L;
        BankAccount bankAccountInfo = new BankAccount(1232, 5468, "JP Morgan");

        //When
        when(bankAccountRepository.findOne(bankAccountId)).thenReturn(bankAccountInfo);
        BankAccount newBankAccount = bankAccountService.getBankAccount(bankAccountId);

        //Then
        assertEquals(1L, newBankAccount.getBankAccountId());
        assertEquals("JP Morgan", newBankAccount.getBankName());
    }

    @Test
    public void updateBankAccount() {




    }

    @Test
    public void deleteBankAccount() {
    }
}