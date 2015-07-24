package com.mtgprofit.core.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfitableTest {

    Profitable profitable = new Profitable();

    private static final int AMOUNT = 5;

    @Test
    public void shouldReturnTopNCards() throws Exception {
        List<CardsProfit> cardsProfits = profitable.getTopCards(AMOUNT);

        assertEquals(AMOUNT, cardsProfits.size());
        for(int i=0; i< cardsProfits.size()-1;i++){
            assertTrue(cardsProfits.get(i).compareTo(cardsProfits.get(i + 1)) >= 0);
        }
    }
}