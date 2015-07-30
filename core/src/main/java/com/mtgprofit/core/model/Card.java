package com.mtgprofit.core.model;

import java.math.BigDecimal;

/**
 * Created by wawszcza on 7/24/2015.
 */
public class Card {
    private final String cardName;
    private final Expansion expansion;
    private final BigDecimal buyPrice;
    private final BigDecimal sellPrice;
    private final String bot;
    private final Shop shop;

    public Card(String cardName, Expansion expansion, BigDecimal buyPrice, BigDecimal sellPrice, String bot, Shop shop) {
        this.cardName = cardName;
        this.expansion = expansion;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.bot = bot;
        this.shop = shop;
    }

    public String getCardName() {
        return cardName;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public String getBot() {
        return bot;
    }

    public Shop getShop() {
        return shop;
    }
}
