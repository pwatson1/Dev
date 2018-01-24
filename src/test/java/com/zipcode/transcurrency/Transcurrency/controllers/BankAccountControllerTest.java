package com.zipcode.transcurrency.Transcurrency.controllers;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.services.BankAccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
public class BankAccountControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BankAccountService bankAccountService;

    @InjectMocks
    private BankAccountController bankAccountController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(bankAccountController)
                .build();

    }

    @Test
    public void getAllBankAccounts() throws Exception {

        BankAccount bankAccount1 = new BankAccount(123, 456, "PNC");
        bankAccount1.setBankAccountId(1L);

        BankAccount bankAccount2 = new BankAccount(1098, 765, "JP Morgan");
        bankAccount2.setBankAccountId(2L);

        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccount1);
        bankAccountList.add(bankAccount2);

        when(bankAccountService.getAllBankAccounts()).thenReturn(bankAccountList);

        Long id1 = 1L;

        mockMvc.perform(get("/bankAccounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].accountNumber", is(123)))
                .andExpect(jsonPath("$[0].routingNumber", is(456)))
                .andExpect(jsonPath("$[0].bankName", is("PNC")));

        verify(bankAccountService, times(1)).getAllBankAccounts();


    }

    @Test
    public void createBankAccount() {

        

    }

    @Test
    public void getBankAccount() throws Exception {

        BankAccount bankAccount = new BankAccount(234, 456, "BitBank");
        Long id = 1L;
        bankAccount.setBankAccountId(id);

        when(bankAccountService.getBankAccount(bankAccount.getBankAccountId())).thenReturn(bankAccount);
        mockMvc.perform(get("/bankAccounts/{bankAccountId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.bankAccountId", is(1)))
                .andExpect(jsonPath("$.accountNumber", is(234)))
                .andExpect(jsonPath("$.routingNumber", is(456)))
                .andExpect(jsonPath("$.bankName", is("BitBank")));

        verify(bankAccountService, times(1)).getBankAccount(id);

    }

    @Test
    public void updateBankAccount() {
    }

    @Test
    public void deleteBankAccount() {
    }
}