package com.zipcode.transcurrency.Transcurrency.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.zipcode.transcurrency.Transcurrency.models.CreditCard;
import com.zipcode.transcurrency.Transcurrency.repositories.CreditCardRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


@Service
public class CreditCardService {
    private static final Logger logger = LogManager.getLogger(CreditCardService.class);

    private CreditCardRepository creditCardRepository;

    private CreditCardService(CreditCardRepository creditCardRepository) {
        logger.info("Committing creditCardRepository to memory.");
        this.creditCardRepository = creditCardRepository;
    }

    //gets all credit cards
    public ResponseEntity<Iterable<CreditCard>> getAllCreditCards() {
        logger.info("Retrieving all creditCards.");
        Iterable<CreditCard> allCreditCards = creditCardRepository.findAll();
        return new ResponseEntity<>(allCreditCards, HttpStatus.OK);
    }

    //creates a credit card
    public ResponseEntity<?> createCreditCard(CreditCard creditCard) {
        logger.info("New creditCard generated.");

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
        logger.info("CreditCard retrieved.");
        CreditCard card = creditCardRepository.findOne(creditCardId);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    //updates credit card info
    public ResponseEntity<?> updateCreditCard(CreditCard creditCard, Long creditCardId) {
        logger.info("CreditCard info modified.");
        CreditCard card = creditCardRepository.save(creditCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //deletes a credit card
    public ResponseEntity<?> deleteCreditCard(Long creditCardId) {
        logger.info("CreditCard deleted.");
        creditCardRepository.delete(creditCardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
