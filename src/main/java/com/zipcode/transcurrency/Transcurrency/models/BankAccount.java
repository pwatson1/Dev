package com.zipcode.transcurrency.Transcurrency.models;

public class BankAccount {

    private Long id;
    private int accountNum;
    private int routingNum;
    private String bankName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public int getRoutingNum() {
        return routingNum;
    }

    public void setRoutingNum(int routingNum) {
        this.routingNum = routingNum;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
