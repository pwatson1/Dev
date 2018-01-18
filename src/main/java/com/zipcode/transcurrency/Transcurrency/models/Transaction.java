package com.zipcode.transcurrency.Transcurrency.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

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

    public Transaction(Long id, Long sourceUserId, Long destinationUserId, Long amount, Long sourceUserAccountId, Long destinationUserAccountId, Long transactionId) {
        this.id = id;
        this.sourceUserId = sourceUserId;
        this.destinationUserId = destinationUserId;
        this.amount = amount;
        this.sourceUserAccountId = sourceUserAccountId;
        this.destinationUserAccountId = destinationUserAccountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(Long sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public Long getDestinationUserId() {
        return destinationUserId;
    }

    public void setDestinationUserId(Long destinationUserId) {
        this.destinationUserId = destinationUserId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getSourceUserAccountId() {
        return sourceUserAccountId;
    }

    public void setSourceUserAccountId(Long sourceUserAccountId) {
        this.sourceUserAccountId = sourceUserAccountId;
    }

    public Long getDestinationUserAccountId() {
        return destinationUserAccountId;
    }

    public void setDestinationUserAccountId(Long destinationUserAccountId) {
        this.destinationUserAccountId = destinationUserAccountId;
    }

}
