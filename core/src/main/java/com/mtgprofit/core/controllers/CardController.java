package com.mtgprofit.core.controllers;

import com.mtgprofit.core.model.CardsProfit;
import com.mtgprofit.core.model.CardsRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wawszcza on 7/24/2015.
 */

@RestController
public class CardController {

    @Autowired
    CardsRetriever cardsRetriever;

    @RequestMapping("/cards")
    public List<CardsProfit> cards(@RequestParam(value="amount", defaultValue="50") int amount)
    {
        return cardsRetriever.getTopCards(amount);
    }
}
