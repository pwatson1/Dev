package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.CreditCard;
import com.zipcode.transcurrency.Transcurrency.repositories.CreditCardRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Service
public class CreditCardService {

    private CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    //gets all credit cards
//    public ResponseEntity<Iterable<CreditCard>> getAllCreditCards() {
//        Iterable<CreditCard> allCreditCards = creditCardRepository.findAll();
//        return new ResponseEntity<>(allCreditCards, HttpStatus.OK);
//    }

    public List<CreditCard> getAllCreditCards() {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCardRepository.findAll()
                .forEach(creditCards::add);
        return creditCards;
    }

    //creates a credit card
    public ResponseEntity<?> createCreditCard(CreditCard creditCard) {

        creditCard = creditCardRepository.save(creditCard);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCreditCardURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{creditCardId}")
                .buildAndExpand(creditCard.getCreditCardId())
                .toUri();
        responseHeaders.setLocation(newCreditCardURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //gets a single credit card
    public ResponseEntity<?> getCreditCard(Long creditCardId) {
        CreditCard card = creditCardRepository.findOne(creditCardId);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    //updates credit card info
    public ResponseEntity<?> updateCreditCard(CreditCard creditCard, Long creditCardId) {
        CreditCard card = creditCardRepository.save(creditCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //deletes a credit card
    public ResponseEntity<?> deleteCreditCard(Long creditCardId) {
        creditCardRepository.delete(creditCardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
