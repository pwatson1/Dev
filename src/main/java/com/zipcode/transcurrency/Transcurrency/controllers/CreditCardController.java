package com.zipcode.transcurrency.Transcurrency.controllers;


import com.zipcode.transcurrency.Transcurrency.models.CreditCard;
import com.zipcode.transcurrency.Transcurrency.services.CreditCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
public class CreditCardController {
    private final Logger LOG = LoggerFactory.getLogger(CreditCardController.class);

    private CreditCardService creditCardService;

    public CreditCardController() {

    }

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    //gets all the credit cards
    @RequestMapping(value = "/creditCards", method = RequestMethod.GET)
    public ResponseEntity<Iterable<CreditCard>> getAllCreditCards() {

        LOG.info("gets all the credit cards");
        return creditCardService.getAllCreditCards();
    }

    //creates credit cards
    @RequestMapping(value = "/creditCards", method = RequestMethod.POST)
    public ResponseEntity<?> createCreditCard(@RequestBody CreditCard creditCard) {

        LOG.info("creates credit cards");
        return creditCardService.createCreditCard(creditCard);
    }

    //gets a credit card
    @RequestMapping(value = "/creditCards/{creditCardId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCreditCard(@PathVariable Long creditCardId) {

        LOG.info("gets a credit card");
        return creditCardService.getCreditCard(creditCardId);
    }

    //update a credit card. May not be needed
    @RequestMapping(value = "/creditCards/{creditCardId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCreditCard(@RequestBody CreditCard creditCard, @PathVariable Long creditCardId) {

        LOG.info("update a credit card. May not be needed");
        return creditCardService.updateCreditCard(creditCard, creditCardId);
    }

    //delete a credit card
    @RequestMapping(value = "/creditCards/{creditCardId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCreditCard(@PathVariable Long creditCardId) {

        LOG.info("delete a credit card");
        return creditCardService.deleteCreditCard(creditCardId);
    }

}
