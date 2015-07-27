package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.Shop;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wawszcza on 7/27/2015.
 */
public class SupernovaParser implements ShopParser {
    @Override
    public List<Card> getCards(List<Expansion> expansions, BigDecimal minPrice) {
        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect(Shop.SUPERNOVABOTS.getAddress()).get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {

                // get the value from href attribute
                System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
