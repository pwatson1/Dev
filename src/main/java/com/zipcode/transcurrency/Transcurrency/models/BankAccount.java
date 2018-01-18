package com.zipcode.transcurrency.Transcurrency.models;


import javax.persistence.*;

@Entity
public class BankAccount {

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
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void transferTo(BankAccount toBankAccount, double amount) {
    }
}
