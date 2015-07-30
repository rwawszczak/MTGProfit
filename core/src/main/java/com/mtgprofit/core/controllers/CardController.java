package com.mtgprofit.core.controllers;

import com.google.common.collect.Lists;
import com.mtgprofit.core.model.CardsProfit;
import com.mtgprofit.core.model.CardsRetriever;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wawszcza on 7/24/2015.
 */

@RestController
public class CardController {

    @Autowired
    CardsRetriever cardsRetriever;

    @RequestMapping("/cards")
    public List<CardsProfit> cards(@RequestParam(value="amount", defaultValue="50") int amount, @RequestParam(value="expansions", required = false)  List<Expansion> expansions, @RequestParam(value="shops", required = false)  List<Shop> shops, @RequestParam(value="minimalPrice", defaultValue="0") BigDecimal minimalPrice)
    {
        if(expansions == null) expansions = Lists.newArrayList(Expansion.values());
        if(shops == null) shops = Lists.newArrayList(Shop.values());
        return cardsRetriever.getTopCards(amount,expansions, shops, minimalPrice);
    }
}
