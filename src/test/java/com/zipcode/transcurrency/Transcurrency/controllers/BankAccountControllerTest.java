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
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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



    }

    @Test
    public void createBankAccount() {
    }

    @Test
    public void getBankAccount() {
    }

    @Test
    public void updateBankAccount() {
    }

    @Test
    public void deleteBankAccount() {
    }
}