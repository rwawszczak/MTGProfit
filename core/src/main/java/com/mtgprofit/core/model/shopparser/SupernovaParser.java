package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.Shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wawszcza on 7/27/2015.
 */
public class SupernovaParser implements ShopParser {
    @Override
    public List<Card> getCards(List<Expansion> expansions, BigDecimal minPrice) {
        List<Card> cards = new ArrayList<>();
        try {
            URL url = new URL(getAddress());
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(), "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                if(inputLine.matches(getExpRegex(expansions))&&aboveMinPrice(inputLine,minPrice))
                    cards.add(parseCard(inputLine));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cards;
    }

    protected String getAddress() {
        return Shop.SUPERNOVABOTS.getAddress();
    }

    private boolean aboveMinPrice(String inputLine, BigDecimal minPrice) {
        Pattern p = Pattern.compile("([0-9]+\\.?[0-9]*)");
        Matcher m = p.matcher(inputLine);

        return m.find() && Double.parseDouble(m.group(0)) >= minPrice.doubleValue();
    }

    private Card parseCard(String inputLine) {
        String name = getCardName(inputLine);
        Expansion exp = getExpansion(inputLine);
        System.out.println(exp);
        System.out.println(inputLine); //TODO: parse input
        return null;
    }

    private Expansion getExpansion(String inputLine) {
        return Expansion.getExpansion(inputLine.substring(inputLine.indexOf('[') + 1, inputLine.indexOf(']')));
    }

    private String getCardName(String inputLine) {
        return inputLine.substring(0,inputLine.indexOf(" ["));
    }

    private String getExpRegex(List<Expansion> expansions) {
        StringBuilder builder = new StringBuilder("^.*(");
        for(int i=0; i<expansions.size()-1; i++) {
            builder.append(expansions.get(i).getNames()[0]);
            builder.append("|");
        }
        builder.append(expansions.get(expansions.size()-1).getNames()[0]);
        builder.append(").*$");
        return  builder.toString();
    }
}
