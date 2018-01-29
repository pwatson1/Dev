package com.zipcode.transcurrency.Transcurrency.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Transaction {
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    @Id
    @GeneratedValue
    private Long id;

    private Long sourceUserId;
    private Long destinationUserId;
    private Long amount;
    private Long sourceUserAccountId;
    private Long destinationUserAccountId;

    public Transaction(){}

    public Transaction(Long id){
        this.id = id;
    }

    public Transaction(Long id, Long sourceUserId, Long destinationUserId, Long amount, Long sourceUserAccountId, Long destinationUserAccountId) {
        this.id = id;
        this.sourceUserId = sourceUserId;
        this.destinationUserId = destinationUserId;
        this.amount = amount;
        this.sourceUserAccountId = sourceUserAccountId;
        this.destinationUserAccountId = destinationUserAccountId;
    }

    public Long getId() {

        logger.info("transactionGetId");
        return id;
    }

    public void setId(Long id) {

        logger.info("transactionSetId");
        this.id = id;
    }

    public Long getSourceUserId() {

        logger.info("transactionGetSourceUserId");
        return sourceUserId;
    }

    public void setSourceUserId(Long sourceUserId) {

        logger.info("transactionSetSourceUserId");
        this.sourceUserId = sourceUserId;
    }

    public Long getDestinationUserId() {

        logger.info("transactionGetDestinationUserId");
        return destinationUserId;
    }

    public void setDestinationUserId(Long destinationUserId) {

        logger.info("transactionSetDestinationUserId");
        this.destinationUserId = destinationUserId;
    }

    public Long getAmount() {

        logger.info("transactionGetAmount");
        return amount;
    }

    public void setAmount(Long amount) {

        logger.info("transactionSetAmount");
        this.amount = amount;
    }

    public Long getSourceUserAccountId() {

        logger.info("transactionGetSourceUserAccountId");
        return sourceUserAccountId;
    }

    public void setSourceUserAccountId(Long sourceUserAccountId) {

        logger.info("transactionSetSourceUserAccountId");
        this.sourceUserAccountId = sourceUserAccountId;
    }

    public Long getDestinationUserAccountId() {

        logger.info("transactionGetDestinationUserAccountId");
        return destinationUserAccountId;
    }

    public void setDestinationUserAccountId(Long destinationUserAccountId) {

        logger.info("transactionSetDestinationUserAccountId");
        this.destinationUserAccountId = destinationUserAccountId;
    }

    @Override
    public boolean equals(Object o) {
        logger.info("transactionEquals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sourceUserId, that.sourceUserId) &&
                Objects.equals(destinationUserId, that.destinationUserId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(sourceUserAccountId, that.sourceUserAccountId) &&
                Objects.equals(destinationUserAccountId, that.destinationUserAccountId);
    }

    @Override
    public int hashCode() {
        logger.info("transaction card data");
        return Objects.hash(id, sourceUserId, destinationUserId, amount, sourceUserAccountId, destinationUserAccountId);
    }
}
