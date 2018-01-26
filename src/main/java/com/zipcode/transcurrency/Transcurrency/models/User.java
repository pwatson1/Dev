package com.zipcode.transcurrency.Transcurrency.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String username;
    private BigDecimal balance;

    @OneToMany
    private Set<BankAccount> bankAccountList = new HashSet<>();

    @OneToMany
    private Set<CreditCard> creditCardList = new HashSet<>();

    public User() {
    }

    //set balance to zero when user instance is created
    public User(String name, String username) {
        this(name, username, BigDecimal.ZERO);
    }

    public User(String name, String username, BigDecimal balance) {
        this(null, name, username, balance);
    }

    public User(Long id, String name, String username, BigDecimal balance) {
        this.name = name;
        this.username = username;
        this.balance = balance;
        this.id = id;
    }

    public Long getId() {

        logger.info("userGetId");
        return id;
    }

    public void setId(Long id) {

        logger.info("userSetId");
        this.id = id;
    }

    public String getName() {

        logger.info("userGetName");
        return name;
    }

    public void setName(String name) {

        logger.info("userSetName");
        this.name = name;
    }

    public String getUsername() {

        logger.info("getUsername");
        return username;
    }

    public void setUsername(String username) {

        logger.info("setUsername");
        this.username = username;
    }

    public BigDecimal getBalance() {

        logger.info("useGetBalance");
        return balance;
    }

    public void setBalance(BigDecimal balance) {

        logger.info("userSetBalance");
        this.balance = balance;
    }

    public Set<BankAccount> getBankAccountList() {

        logger.info("userGetBankAccountList");
        return bankAccountList;
    }

    public void setBankAccountList(Set<BankAccount> bankAccountList) {

        logger.info("userSetBankAccountList");
        this.bankAccountList = bankAccountList;
    }

    public Set<CreditCard> getCreditCardList() {

        logger.info("userGetCreditCardList");
        return creditCardList;
    }

    public void setCreditCardList(Set<CreditCard> creditCardList) {

        logger.info("userSetCreditCardList");
        this.creditCardList = creditCardList;
    }
}