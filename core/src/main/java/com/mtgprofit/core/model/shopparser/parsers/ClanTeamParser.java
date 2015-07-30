package com.mtgprofit.core.model.shopparser.parsers;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.Shop;
import com.mtgprofit.core.model.shopparser.ShopParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wawszcza on 7/30/2015.
 */
public class ClanTeamParser implements ShopParser {

    private static final String DATA_START_LINE = "var d = [[";

    @Override
    public Map<String,Card> getCards(List<Expansion> expansions, BigDecimal minPrice) {
        Map<String,Card> cards = new HashMap<>();
        for(Expansion exp : expansions)
            cards.putAll(getExpansionCards(exp, minPrice));
        return cards;
    }

    private Map<String,Card> getExpansionCards(Expansion expansion, BigDecimal minPrice) {
        String address = getExpansionAddress(expansion.getNames()[0]);
        Map<String,Card> cards = new HashMap<>();
        String content = getContent(address);
        if(content == null) return cards;//TODO: log warning

        Matcher cm = getCardMatcher(content);

        int cardId=0;
        while(cm.find()) {
            Matcher buyMatcher = getPriceMatcher(content, 2,cardId);
            Matcher sellMatcher = getPriceMatcher(content, 3,cardId);
            boolean buyFound = buyMatcher.find();
            boolean sellFound = sellMatcher.find();
            if((buyFound||sellFound)&&(Double.parseDouble(buyMatcher.group(1))>=minPrice.doubleValue()||Double.parseDouble(sellMatcher.group(1))>=minPrice.doubleValue())){
                String name = cm.group(1);
                String bot = cm.group(2);
                BigDecimal buy = buyFound ? new BigDecimal(buyMatcher.group(1)) : null;
                BigDecimal sell = sellFound ? new BigDecimal(sellMatcher.group(1)) : null;

                Card c = new Card(name, expansion, buy, sell, bot, Shop.CLANTEAM);
                cards.put(c.getCardName()+c.getExpansion(),c);
            }
            cardId++;
        }

        return cards;
    }

    private Matcher getCardMatcher(String content) {
        return Pattern.compile("\\[\"([^\"]+)\",\"[A-Z]\",\"\",\"\",\"([a-zA-Z0-9\\s\\(\\),]+)\"\\]").matcher(content);
    }

    private Matcher getPriceMatcher(String content, int column, int cardId) {
        return Pattern.compile("d\\["+cardId+"\\]\\["+column+"\\]=([0-9]+\\.?[0-9]*);").matcher(content);
    }

    private String getContent(String address) {
        try {
            URL url = new URL(address);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(), "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                if(inputLine.contains(DATA_START_LINE))
                    return inputLine;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getExpansionAddress(String expansionName) {
        return String.format(Shop.CLANTEAM.getAddress(), expansionName);
    }
}
