package com.zipcode.transcurrency.Transcurrency.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
public class BankAccount {

    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BANK_ACCOUNT_ID")
    private Long bankAccountId;

    @JoinColumn(name = "ACCOUNT_NUMBER")
    private int accountNumber;

    //@Column(name = "ROUTING_NUMBER")
    private int routingNumber;

    //@Column(name = "BANK_NAME")
    private String bankName;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BankAccount(){

    }

    public BankAccount(Long bankAccountId, int accountNumber, int routingNumber, String bankName){
        this.bankAccountId = bankAccountId;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
        this.bankName = bankName;
    }

    public long getBankAccountId() {
        logger.info("Retrieving bankAccountId.");
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        logger.info("Committing CreditCardId to memory.");
        this.bankAccountId = bankAccountId;
    }

    public int getAccountNumber() {
        logger.info("Retrieving accountNumber.");
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        logger.info("Committing accountNumber to memory.");
        this.accountNumber = accountNumber;
    }

    public int getRoutingNumber() {
        logger.info("Retrieving routingNumber.");
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        logger.info("Committing routingNumber to memory.");
        this.routingNumber = routingNumber;
    }

    public String getBankName() {
        logger.info("Retrieving bankName.");
        return bankName;
    }

    public void setBankName(String bankName) {
        logger.info("Committing bankName to memory.");
        this.bankName = bankName;
    }

    public void transferTo(BankAccount toBankAccount, double amount) {
    }


}
