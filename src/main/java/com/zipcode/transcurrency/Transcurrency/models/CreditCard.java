package com.zipcode.transcurrency.Transcurrency.models;


import javax.persistence.*;

@Entity
public class CreditCard {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CREDIT_CARD_ID")
    private Long creditCardId;

    @JoinColumn(name = "CARD_NAME")
    private String cardName;
    private int cardNumber;
    private String expDate;
    private int cvv;

    @ManyToOne
    private User user;

    public CreditCard(){

    }

    public CreditCard(String cardName, int cardNumber, String expDate, int cvv){
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;

    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long CreditCardId) {
        this.creditCardId = CreditCardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
