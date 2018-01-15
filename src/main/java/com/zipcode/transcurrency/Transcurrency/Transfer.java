package com.zipcode.transcurrency.Transcurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;

import java.math.BigDecimal;

public class Transfer {
    private static final Logger logger = LogManager.getLogger(Transfer.class);

    private BankAccount toBankAccount; //field for instantiating bank account object
    private BigDecimal amount;

    public Transfer(BankAccount toBankAccount, BigDecimal amount) {
        logger.info("Committing transfer to memory.");
        this.toBankAccount = toBankAccount;
        this.amount = amount;
    }

    public void withdraw(BankAccount fromBankAccount) {
//        toBankAccount.withdrawal(amount)
        //request money from bank account, or credit card
        //update balance accordingly
    }

    public void deposit() {
//        toBankAccount.deposit(amount)
        //send money from app to bank account
        //uodate balance
    }

}
