package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.Shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by wawszcza on 7/27/2015.
 */
public class SupernovaParser implements ShopParser {
    @Override
    public List<Card> getCards(List<Expansion> expansions, BigDecimal minPrice) {
        try {
            URL url = new URL(Shop.SUPERNOVABOTS.getAddress());
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(), "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                if(inputLine.contains("[DTK]")) //TODO: change for regex
                    System.out.println(inputLine); //TODO: parse input
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
