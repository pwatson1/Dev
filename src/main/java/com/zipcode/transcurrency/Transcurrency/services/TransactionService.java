package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.Transaction;
import com.zipcode.transcurrency.Transcurrency.repositories.TransactionRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private static final Logger logger = LogManager.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {

        this.transactionRepository = transactionRepository;

    }

    public List<Transaction> getAllTransactions() {

        logger.info("getAllTransactions");
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions;

    }

    public Transaction getTransactionById(Long id) {

        logger.info("getTransactionById");
        Transaction transaction = transactionRepository.findOne(id);
        return transaction;

    }

    public void createTransaction(Transaction transaction) {

        logger.info("createTransaction");
        transactionRepository.save(transaction);

    }

    public void deleteTransactionById(Long id) {

        logger.info("deleteTransactionById");
        transactionRepository.delete(id);

    }

    public void updateTransaction(Transaction transaction) {

        logger.info("updateTransaction");
        transactionRepository.save(transaction);
    }

    public boolean exists(Transaction transaction) {

        logger.info("exists check");
        return getTransactionById(transaction.getId()) != null;
    }
}
