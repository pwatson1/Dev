package com.zipcode.transcurrency.Transcurrency.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

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

    public Transaction(Long id, Long sourceUserId, Long destinationUserId, Long amount, Long sourceUserAccountId, Long destinationUserAccountId) {
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

    @Override
    public boolean equals(Object o) {
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
        return Objects.hash(id, sourceUserId, destinationUserId, amount, sourceUserAccountId, destinationUserAccountId);
    }
}
