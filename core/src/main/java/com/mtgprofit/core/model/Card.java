package com.mtgprofit.core.model;

import java.math.BigDecimal;

/**
 * Created by wawszcza on 7/24/2015.
 */
public class Card {
    private final String cardName;
    private final String expansionName;
    private final BigDecimal sellPrice;
    private final BigDecimal buyPrice;
    private final String bot;
    private final String shop;

    public Card(String cardName, String expansionName, BigDecimal sellPrice, BigDecimal buyPrice, String bot, String shop) {
        this.cardName = cardName;
        this.expansionName = expansionName;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.bot = bot;
        this.shop = shop;
    }

    public String getCardName() {
        return cardName;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public String getBot() {
        return bot;
    }

    public String getShop() {
        return shop;
    }
}
