package com.zipcode.transcurrency.Transcurrency.controllers;

import com.zipcode.transcurrency.Transcurrency.config.WebConfig;
import com.zipcode.transcurrency.Transcurrency.filter.CorsFilter;
import com.zipcode.transcurrency.Transcurrency.models.Transaction;
import com.zipcode.transcurrency.Transcurrency.services.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
public class TransactionControllerTests {

    private MockMvc mockMvc;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(transactionController)
                .addFilter(new CorsFilter())
                .build();
    }

    // GET ALL TRANSACTIONS

    @Test
    public void test_get_all_transactions_success() throws Exception {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L),
                new Transaction(2L));

        when(transactionService.getAllTransactions()).thenReturn(transactions);

        mockMvc.perform(get("/transactions/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));

        verify(transactionService, times(1)).getAllTransactions();
        verifyNoMoreInteractions(transactionService);

    }
}
