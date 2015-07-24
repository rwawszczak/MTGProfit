package com.mtgprofit.core.model;

import java.math.BigDecimal;

/**
 * Created by wawszcza on 7/24/2015.
 */
public class CardsProfit implements Comparable<CardsProfit> {
    private BigDecimal profit;
    private final String cardName;
    private final String expansionName;
    private final BigDecimal sellPrice;
    private final BigDecimal buyPrice;
    private final String sellBot;
    private final String buyBot;
    private final String sellShop;
    private final String buyShop;

    public CardsProfit(BigDecimal profit, String cardName, String expansionName, BigDecimal sellPrice, BigDecimal buyPrice, String sellBot, String buyBot, String sellShop, String buyShop) {
        this.profit = profit;
        this.cardName = cardName;
        this.expansionName = expansionName;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.sellBot = sellBot;
        this.buyBot = buyBot;
        this.sellShop = sellShop;
        this.buyShop = buyShop;
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

    public String getSellShop() {
        return sellShop;
    }

    public String getBuyShop() {
        return buyShop;
    }

    @Override
    public int compareTo(CardsProfit o) {
        return profit.compareTo(o.profit);
    }
}
