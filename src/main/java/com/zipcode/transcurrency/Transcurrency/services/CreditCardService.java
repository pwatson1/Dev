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


    public List<CreditCard> getAllCreditCards() {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCardRepository.findAll()
                .forEach(creditCards::add);
        return creditCards;
    }

    //creates a credit card
    public HttpHeaders createCreditCard(CreditCard creditCard) {

        creditCard = creditCardRepository.save(creditCard);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCreditCardURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{creditCardId}")
                .buildAndExpand(creditCard.getCreditCardId())
                .toUri();
        responseHeaders.setLocation(newCreditCardURI);

        return responseHeaders;
    }

    //gets a single credit card
    public CreditCard getCreditCard(Long creditCardId) {
        return creditCardRepository.findOne(creditCardId);
    }

    //updates credit card info
    public CreditCard updateCreditCard(CreditCard creditCard, Long creditCardId) {
        return creditCardRepository.save(creditCard);
    }

    //deletes a credit card
    public Boolean deleteCreditCard(Long creditCardId) {
        creditCardRepository.delete(creditCardId);
        return true;
    }

}
