package com.mtgprofit.core.model;

import com.mtgprofit.core.model.shopparser.ShopParserFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wawszcza on 7/24/2015.
 */
@Component
public class CardsRetriever {

    public List<CardsProfit> getTopCards(int amount, List<Expansion> expansions, List<Shop> shops, BigDecimal minimalPrice) {
        List<CardsProfit> cards = getAllCards(expansions, shops, minimalPrice);
        return cards.size()>amount ? cards.subList(0,amount) : cards;
    }

    public List<CardsProfit> getAllCards(List<Expansion> expansions, List<Shop> shops, BigDecimal minimalPrice) {
        Map<Shop, Map<String,Card>> cards = getShopCardsMap(expansions, minimalPrice);

        List<CardsProfit> cardsProfits = new ArrayList<>();
        for(Shop shop : shops){
            for(String cardName : cards.get(shop).keySet()){
                for(Shop s : shops){
                    if(shop!=s&&cards.get(s).get(cardName)!=null&&cards.get(shop).get(cardName).getBuyPrice()!=null&&cards.get(s).get(cardName).getSellPrice()!=null){
                        BigDecimal profit = cards.get(shop).get(cardName).getBuyPrice().subtract(cards.get(s).get(cardName).getSellPrice());;

                        if(profit.doubleValue()>0){
                            cardsProfits.add(new CardsProfit(profit,
                                    cards.get(shop).get(cardName).getCardName(),
                                    cards.get(shop).get(cardName).getExpansion().names[0],
                                    cards.get(shop).get(cardName).getBuyPrice(),
                                    cards.get(s).get(cardName).getSellPrice(),
                                    cards.get(shop).get(cardName).getBot(),
                                    cards.get(s).get(cardName).getBot(),
                                    shop.getName(), s.getName()));
                        }
                    }
                }
            }
        }
        Collections.sort(cardsProfits);
        Collections.reverse(cardsProfits);
        return cardsProfits;
    }

    private Map<Shop, Map<String,Card>> getShopCardsMap(List<Expansion> expansions, BigDecimal minimalPrice) {
        Map<Shop,Map<String,Card>> cards = new HashMap<>();
        ShopParserFactory factory = getShopParserFactory();
        for(Shop s : Shop.values()){
            cards.put(s,factory.getShopParser(s).getCards(expansions,minimalPrice));
        }
        return cards;
    }

    protected ShopParserFactory getShopParserFactory() {
        return new ShopParserFactory();
    }
}
