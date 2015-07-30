package com.mtgprofit.core.model;

import java.math.BigDecimal;

/**
 * Created by wawszcza on 7/24/2015.
 */
public class CardsProfit implements Comparable<CardsProfit> {
    private BigDecimal profit;
    private final String cardName;
    private final String expansionName;
    private final BigDecimal buyPrice;
    private final BigDecimal sellPrice;
    private final String buyBot;
    private final String sellBot;
    private final String buyShop;
    private final String sellShop;

    public CardsProfit(BigDecimal profit, String cardName, String expansionName, BigDecimal buyPrice, BigDecimal sellPrice, String buyBot, String sellBot, String buyShop, String sellShop) {
        this.profit = profit;
        this.cardName = cardName;
        this.expansionName = expansionName;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.buyBot = buyBot;
        this.sellBot = sellBot;
        this.buyShop = buyShop;
        this.sellShop = sellShop;
    }

    public BigDecimal getProfit() {
        return profit;
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

    public String getSellBot() {
        return sellBot;
    }

    public String getBuyBot() {
        return buyBot;
    }

    public String getBuyShop() {
        return buyShop;
    }

    public String getSellShop() {
        return sellShop;
    }

    @Override
    public int compareTo(CardsProfit o) {
        return profit.compareTo(o.profit);
    }
}
