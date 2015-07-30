package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.shopparser.parsers.ClanTeamParser;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mtgprofit.core.model.Expansion.DTK;
import static junit.framework.Assert.assertTrue;

public class ClanTeamParserTest {
    ClanTeamParser parser = getTestParser();
    List<Expansion> expansions= getExpansionList(DTK);

    @Test
    public void getsSomeCards() throws Exception {
        List<Card> cards = parser.getCards(expansions,new BigDecimal(0));

        assertTrue(cards.size()>0);
    }

    @Test
    public void getsCardsFromCorrectExpansion() throws Exception {
        List<Card> cards = parser.getCards(expansions,new BigDecimal(0));

        for(Card c : cards)
            assertTrue(c.getExpansion()==DTK);
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

    private ClanTeamParser getTestParser() {
        return new ClanTeamParser(){
            @Override
            protected String getExpansionAddress(String expansionName) {
                return new File("src/test/resources/ClanTeamDTK.html").toURI().toString();
            }
        };
    }
}