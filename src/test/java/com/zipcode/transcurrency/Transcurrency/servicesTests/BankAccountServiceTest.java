package com.zipcode.transcurrency.Transcurrency.servicesTests;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.repositories.BankAccountRepository;
import com.zipcode.transcurrency.Transcurrency.services.BankAccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BankAccountServiceTest {


private BankAccountService service;

@Mock
private BankAccountRepository bankAccountRepository;

@InjectMocks
private BankAccountService bankAccountService;



@Before
public void setUp() throws Exception {

MockitoAnnotations.initMocks(this);
bankAccountService = new BankAccountService(bankAccountRepository);
}

@Test
public void getAllBankAccountsTest() {
//Given:
BankAccount bankAccount1 = new BankAccount();
List<BankAccount> bankAccountList = new ArrayList<>();
bankAccountList.add(bankAccount1);
BankAccountRepository bankAccountRepository = (BankAccountRepository) bankAccountService.getAllBankAccounts();

//When:
when(bankAccountService.getAllBankAccounts()).thenReturn((ResponseEntity<Iterable<BankAccount>>) bankAccountList);

//Then:
assertEquals(bankAccountList.size(), 1);
}

@Test
public void updateBankAccountTest() {
//Given:
//make a bank account, change that bank account

//When:

//Then:
//assert that the altered bank does not equal the original bank account
}

@Test
public void deleteBankAccountTest() {
//Given:
//add a bank account

//When:
//delete bank account

//Then:
//assert that repository is empty
}


}
