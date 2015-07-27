package com.mtgprofit.core.model.shopparser;

import com.google.common.collect.ImmutableMap;
import com.mtgprofit.core.model.Shop;

import static com.mtgprofit.core.model.Shop.*;

/**
 * Created by wawszcza on 7/27/2015.
 */
public class ShopParserFactory {
    static final ImmutableMap<Shop, ShopParser> SHOPS = new ImmutableMap.Builder<Shop,ShopParser>()
            .put(SUPERNOVABOTS, new SupernovaParser())
            .build();
    public ShopParser getShopParser(Shop shop){
        return SHOPS.get(shop);
    }
}
