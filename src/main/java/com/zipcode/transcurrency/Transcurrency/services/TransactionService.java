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

    public boolean saveTransaction(Transaction transaction) {

        if(transactionRepository.equals(transaction)) {
            return false;
        }

        transactionRepository.save(transaction);
        return true;

    }

    public void deleteTransaction(Long id) {

        Transaction transaction = getTransactionById(id);
        transactionRepository.delete(transaction);

    }

    public void updateTransaction(Transaction transaction) {
        int index = transactionRepository.findAll()
                .indexOf(getTransactionById(transaction.getId()));
        transactionRepository.findAll().set(index, transaction);
    }


}
