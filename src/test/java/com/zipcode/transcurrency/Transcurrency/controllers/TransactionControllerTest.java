package com.zipcode.transcurrency.Transcurrency.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcode.transcurrency.Transcurrency.configs.CorsConfiguration;
import com.zipcode.transcurrency.Transcurrency.configs.WebConfiguration;
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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfiguration.class})
public class TransactionControllerTest {

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
                .addFilter(new CorsConfiguration(), "/*")
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

    // GET TRANSACTION BY ID

    @Test
    public void test_get_by_id_success() throws Exception {
        Transaction transaction = new Transaction(1L);

        when(transactionService.getTransactionById(1L)).thenReturn(transaction);

        mockMvc.perform(get("/transactions/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)));

        verify(transactionService, times(1)).getTransactionById(1L);
        verifyNoMoreInteractions(transactionService);
    }

    @Test
    public void test_get_by_id_fail_404_not_found() throws Exception {
        when(transactionService.getTransactionById(1L)).thenReturn(null);

        mockMvc.perform(get("/transactions/{id}", 1L))
                .andExpect(status().isNotFound());

        verify(transactionService, times(1)).getTransactionById(1L);
        verifyNoMoreInteractions(transactionService);
    }

    // CREATE NEW TRANSACTION

    @Test
    public void test_create_transaction_success() throws Exception {
        Transaction transaction = new Transaction(1L, 12L, 13L, 1234L, 12345L, 12346L);

        when(transactionService.exists(transaction)).thenReturn(false);
        doNothing().when(transactionService).createTransaction(transaction);

        mockMvc.perform(
                post("/transactions/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(transaction)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("/transactions/1")));

        verify(transactionService, times(1)).exists(transaction);
        verify(transactionService, times(1)).createTransaction(transaction);
    }

    @Test
    public void test_create_transaction_fail_409_conflict() throws Exception {
        Transaction transaction = new Transaction(1L);

        when(transactionService.exists(transaction)).thenReturn(true);

        mockMvc.perform(
                post("/transactions/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(transaction)))
                .andExpect(status().isConflict());

        verify(transactionService, times(1)).exists(transaction);
        verifyNoMoreInteractions(transactionService);
    }

    @Test
    public void test_update_person_success() throws Exception {
        Transaction transaction = new Transaction(1L);

        when(transactionService.getTransactionById(transaction.getId())).thenReturn(transaction);
        doNothing().when(transactionService).updateTransaction(transaction);

        mockMvc.perform(
                put("/transactions/{id}", transaction.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(transaction)))
                .andExpect(status().isOk());

        verify(transactionService, times(1)).getTransactionById(transaction.getId());
        verify(transactionService, times(1)).updateTransaction(transaction);
        verifyNoMoreInteractions(transactionService);

    }

    @Test
    public void test_update_person_fail_404_not_found() throws Exception {
        Transaction transaction = new Transaction(999L);

        when(transactionService.getTransactionById(transaction.getId())).thenReturn(null);

        mockMvc.perform(
                put("/transactions/{id}", transaction.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(transaction)))
                .andExpect(status().isNotFound());

        verify(transactionService, times(1)).getTransactionById(transaction.getId());
        verifyNoMoreInteractions(transactionService);
    }

    @Test
    public void test_delete_person_success() throws Exception {

    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
