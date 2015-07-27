package com.mtgprofit.core.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wawszcza on 7/24/2015.
 */
@Component
public class CardsRetriever {

    public List<CardsProfit> getTopCards(int amount) {
        List<CardsProfit> cardsProfits = new ArrayList<CardsProfit>();
        for(int i=0; i<amount; i++){
            cardsProfits.add(new CardsProfit(new BigDecimal(1), "Card"+i,"exp",new BigDecimal(1.1),new BigDecimal(2.1),"A"+i,"B"+i,"C"+i,"D"+i ));
        }
        return cardsProfits;
    }
}
