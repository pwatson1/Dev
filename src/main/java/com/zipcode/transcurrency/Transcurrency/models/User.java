package com.zipcode.transcurrency.Transcurrency.models;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String username;
    private BigDecimal balance;

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    public User(){}

    //set balance to zero when user instance is created
    public User(String name, String username) {
        this(name, username, BigDecimal.ZERO);
    }

    public User(String name, String username, BigDecimal balance) {
        this.name = name;
        this.username = username;
        this.balance = balance;
    }

    public Long getId() {
        logger.info("Retrieving I.D.");
        return id;
    }

    public void setId(Long id) {
        logger.info("Committing id to memory.");
        this.id = id;
    }

    public String getName() {
        logger.info("Retrieving name.");
        return name;
    }

    public void setName(String name) {
        logger.info("Committing name to memory.");
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
