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
import static org.mockito.Matchers.any;
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

    @Test(expected = RuntimeException.class)
    public void createCreditCard() throws Exception{

        when(creditCardRepository.save(any(CreditCard.class))).thenThrow(RuntimeException.class);

        CreditCard creditCardTest = new CreditCard();

        creditCardService.createCreditCard(creditCardTest);

        verify(creditCardRepository, times(1)).save(creditCardTest);
        verify(creditCardRepository).save(any(CreditCard.class));
    }

//    @Test
//    public void getCreditCard() {
//
//
//    }
//
//    @Test
//    public void updateCreditCard() {
//
//        int test = 2;
//
//        assertEquals(1, test);
//    }
//
//    @Test
//    public void deleteCreditCard() {
//
//        int test = 2;
//
//        assertEquals(1, test);
//    }
}