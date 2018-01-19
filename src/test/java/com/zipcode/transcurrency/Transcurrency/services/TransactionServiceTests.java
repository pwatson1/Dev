package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.Transaction;
import com.zipcode.transcurrency.Transcurrency.repositories.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TransactionServiceTests {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTransactionsTest() throws Exception {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction(),
                        new Transaction()));

        when(transactionRepository.findAll())
                .thenReturn(transactionList);

        List<Transaction> transactions = transactionService.getAllTransactions();

        assertEquals(transactions.size(), 2);
    }

    @Test
    public void getTransactionTest() throws Exception {
        Long id = 1L;
        Transaction transactionResult = new Transaction();

        when(transactionRepository.findOne(id))
                .thenReturn(transactionResult);

        Transaction transaction = transactionService.getTransactionById(1L);

        assertThat(transaction, is(notNullValue()));
    }

    @Test
    public void createTransactionTest() throws Exception {
        Transaction createdTransaction = new Transaction(1L, 12L, 13L, 1234L, 12345L, 12346L);

        transactionService.createTransaction(createdTransaction);

        assertThat(1L, is(createdTransaction.getId()));
    }

    @Test
    public void deleteTransactionByIdTest() throws Exception {
        Long id = 1L;
        doNothing().when(transactionRepository).delete(1L);
        transactionService.deleteTransactionById(id);
        verify(transactionRepository, times(1)).delete(1L);
    }

    @Test
    public void updateTransactionTest() throws Exception {

    }
}
