package com.zipcode.transcurrency.Transcurrency.controllers;

import com.zipcode.transcurrency.Transcurrency.models.Transaction;
import com.zipcode.transcurrency.Transcurrency.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    // GET ALL TRANSACTIONS

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getAll() {
        LOG.info("getting all transactions");
        List<Transaction> transactions = transactionService.getAllTransactions();

        if(transactions == null || transactions.isEmpty()) {
            LOG.info("no transactions found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }



}
