package com.zipcode.transcurrency.Transcurrency.models;

import java.util.List;

public class Wallet {

    private List<CreditCard> creditCards;
    private List<BankAccount> bankAccounts;

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

}
