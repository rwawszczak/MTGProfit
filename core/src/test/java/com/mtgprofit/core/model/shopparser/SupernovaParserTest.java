package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.shopparser.parsers.SupernovaParser;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.mtgprofit.core.model.Expansion.DTK;
import static com.mtgprofit.core.model.Expansion.KTK;
import static junit.framework.Assert.assertTrue;

public class SupernovaParserTest {
    SupernovaParser parser = getTestParser();
    List<Expansion> expansions= getExpansionList(DTK, KTK);

    @Test
    public void getsSomeCards() throws Exception {
        Map<String,Card> cards = parser.getCards(expansions,new BigDecimal(0));

        assertTrue(cards.size()>0);
    }

    @Test
    public void getsCardsFromCorrectExpansion() throws Exception {
        Map<String,Card> cards = parser.getCards(expansions,new BigDecimal(0));

        for(String cardName : cards.keySet()) {
            assertTrue(cards.get(cardName).getExpansion() == DTK||cards.get(cardName).getExpansion() == KTK);
        }
    }

    @Test
    public void getsCardsWithCorrectPrice() throws Exception {
        Map<String,Card> cards = parser.getCards(expansions,new BigDecimal(1));

        for(String cardName : cards.keySet())
            assertTrue((cards.get(cardName).getSellPrice()==null||cards.get(cardName).getSellPrice().doubleValue()>1)||(cards.get(cardName).getBuyPrice()==null||cards.get(cardName).getBuyPrice().doubleValue()>1));
    }

    @Test
    public void getBotsWhenSellPrice() throws Exception {
        Map<String,Card> cards = parser.getCards(expansions,new BigDecimal(1));

        for(String cardName : cards.keySet())
            assertTrue((cards.get(cardName).getSellPrice()==null&&cards.get(cardName).getBot()==null)||(cards.get(cardName).getSellPrice()!=null&&cards.get(cardName).getBot()!=null));
    }

    @Test
    public void whenNoBotsAlwaysBuyPrice() throws Exception {
        Map<String,Card> cards = parser.getCards(expansions,new BigDecimal(1));

        for(String cardName : cards.keySet())
            assertTrue(cards.get(cardName).getBot()!=null||cards.get(cardName).getBuyPrice()!=null);
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