package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mtgprofit.core.model.Expansion.*;
import static junit.framework.Assert.assertTrue;

public class SupernovaParserTest {
    SupernovaParser parser = getTestParser();
    List<Expansion> expansions= getExpansionList(DTK, KTK);

    @Test
    public void getsCardsFromCorrectExpansion() throws Exception {
        List<Card> cards = parser.getCards(expansions,new BigDecimal(0));

        for(Card c : cards)
            assertTrue(c.getExpansion()==DTK||c.getExpansion()==KTK);
    }

    @Test
    public void getsCardsWithCorrectPrice() throws Exception {
        List<Card> cards = parser.getCards(expansions,new BigDecimal(1));

        for(Card c : cards)
            assertTrue((c.getSellPrice()==null||c.getSellPrice().doubleValue()>1)||(c.getBuyPrice()==null||c.getBuyPrice().doubleValue()>1));
    }

    @Test
    public void getBotsWhenSellPrice() throws Exception {
        List<Card> cards = parser.getCards(expansions,new BigDecimal(1));

        for(Card c : cards)
            assertTrue((c.getSellPrice()==null&&c.getBot()==null)||(c.getSellPrice()!=null&&c.getBot()!=null));
    }

    @Test
    public void whenNoBotsAlwaysBuyPrice() throws Exception {
        List<Card> cards = parser.getCards(expansions,new BigDecimal(1));

        for(Card c : cards)
            assertTrue(c.getBot()!=null||c.getBuyPrice()!=null);
    }

    private List<Expansion> getExpansionList(Expansion... expansions) {
        List<Expansion> expansionList = new ArrayList<>();
        Collections.addAll(expansionList, expansions);
        return  expansionList;
    }

    private SupernovaParser getTestParser() {
        return new SupernovaParser(){
            @Override
            protected String getAddress() {
                return new File("src/test/resources/supernova.txt").toURI().toString();
            }
        };
    }
}