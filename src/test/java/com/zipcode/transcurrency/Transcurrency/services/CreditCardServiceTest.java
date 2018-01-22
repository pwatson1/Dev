package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.CreditCard;
import com.zipcode.transcurrency.Transcurrency.repositories.CreditCardRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreditCardServiceTest {

    private CreditCardService creditCardService;

    @Mock
    private CreditCardRepository creditCardRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        creditCardService = new CreditCardService(creditCardRepository);
    }

    @Test
    public void getAllCreditCards() {

        CreditCard creditCard = new CreditCard();
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);

        when(creditCardRepository.findAll()).thenReturn(creditCardList);

        List<CreditCard> creditCardTest = creditCardService.getAllCreditCards();

        verify(creditCardRepository, times(1)).findAll();
        assertEquals(creditCardList.size(), 1);
    }

    @Test
    public void createCreditCard() {
    }

    @Test
    public void getCreditCard() {
    }

    @Test
    public void updateCreditCard() {
    }

    @Test
    public void deleteCreditCard() {
    }
}