package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.Transaction;
import com.zipcode.transcurrency.Transcurrency.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {

        this.transactionRepository = transactionRepository;

    }

    public List<Transaction> getAllTransactions() {

        List<Transaction> transactions = transactionRepository.findAll();
        return transactions;

    }

    public Transaction getTransactionById(Long id) {

        Transaction transaction = transactionRepository.findOne(id);
        return transaction;

    }

    public void createTransaction(Transaction transaction) {

        transactionRepository.save(transaction);

    }

    public void deleteTransactionById(Long id) {

        transactionRepository.delete(id);

    }

    public void updateTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public boolean exists(Transaction transaction) {
        return getTransactionById(transaction.getId()) != null;
    }
}
