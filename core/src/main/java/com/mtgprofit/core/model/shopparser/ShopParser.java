package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Card;
import com.mtgprofit.core.model.Expansion;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by wawszcza on 7/27/2015.
 */
public interface ShopParser {
    public Map<String,Card> getCards(List<Expansion> expansions, BigDecimal minPrice);
}
