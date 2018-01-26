package com.zipcode.transcurrency.Transcurrency.controllers;

import com.zipcode.transcurrency.Transcurrency.models.CreditCard;
import com.zipcode.transcurrency.Transcurrency.services.CreditCardService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CreditCardControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CreditCardService creditCardService;

    @InjectMocks
    private CreditCardController creditCardController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup((creditCardController))
                .build();
    }

    @Test
    public void getAllCreditCards() throws Exception {

        CreditCard creditCard1 = new CreditCard("Gary Busy", 1999, "9/06/20", 621);
        creditCard1.setCreditCardId(1L);

        CreditCard creditCard2 = new CreditCard("Joey Bag of Donuts", 1776, "8/30/1492", 696);
        creditCard2.setCreditCardId(2L);

        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(creditCard1);
        creditCardList.add(creditCard2);

        when(creditCardService.getAllCreditCards()).thenReturn(creditCardList);

        mockMvc.perform(get("/creditCards"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].cardName", is("Gary Busy")))
                .andExpect(jsonPath("$[0].cardNumber", is(1999)))
                .andExpect(jsonPath("$[0].expDate", is("9/06/20")))
                .andExpect(jsonPath("$[0].cvv", is(621)));

        verify(creditCardService, times(1)).getAllCreditCards();

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