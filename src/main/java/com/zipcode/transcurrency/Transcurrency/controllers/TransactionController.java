package com.zipcode.transcurrency.Transcurrency.controllers;

import com.zipcode.transcurrency.Transcurrency.models.Transaction;
import com.zipcode.transcurrency.Transcurrency.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    // GET ALL TRANSACTIONS

    @RequestMapping(path = "/getAllTransactions", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        LOG.info("getting all transactions");
        List<Transaction> transactions = transactionService.getAllTransactions();

        if(transactions == null || transactions.isEmpty()) {
            LOG.info("no transactions found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // GET TRANSACTION BY ID

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id) {
        LOG.info("getting transaction with id: {}", id);
        Transaction transaction = transactionService.getTransactionById(id);

        if(transaction == null) {
            LOG.info("person with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    // CREATE NEW TRANSACTION

    @RequestMapping(path = "/createTransaction", method = RequestMethod.POST)
    public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction, UriComponentsBuilder ucBuilder) {
        LOG.info("creating new transaction: {}", transaction);

        if(transactionService.exists(transaction)) {
            LOG.info("a transaction with the id {} already exists", transaction.getId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        transactionService.createTransaction(transaction);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/transactions/{id}").buildAndExpand(transaction.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // UPDATE EXISTING PERSON

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        LOG.info("updating transaction: {}", transaction);
        Transaction currentTransaction = transactionService.getTransactionById(id);

        if (currentTransaction == null)
        {
            LOG.info("Transaction with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentTransaction.setSourceUserId(transaction.getSourceUserId());
        currentTransaction.setDestinationUserId(transaction.getDestinationUserId());
        currentTransaction.setSourceUserAccountId(transaction.getSourceUserAccountId());
        currentTransaction.setDestinationUserAccountId(transaction.getDestinationUserAccountId());
        currentTransaction.setAmount(transaction.getAmount());

        transactionService.updateTransaction(transaction);
        return new ResponseEntity<>(currentTransaction, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id)
    {
        LOG.info("deleting transaction with id: {}", id);
        Transaction transaction = transactionService.getTransactionById(id);

        if (transaction == null)
        {
            LOG.info("Unable to deleteTransaction. Transaction with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        transactionService.deleteTransactionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
