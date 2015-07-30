package com.mtgprofit.core.model.shopparser;

import com.google.common.collect.ImmutableMap;
import com.mtgprofit.core.model.Shop;
import com.mtgprofit.core.model.shopparser.parsers.ClanTeamParser;
import com.mtgprofit.core.model.shopparser.parsers.SupernovaParser;

import static com.mtgprofit.core.model.Shop.CLANTEAM;
import static com.mtgprofit.core.model.Shop.SUPERNOVABOTS;

/**
 * Created by wawszcza on 7/27/2015.
 */
public class ShopParserFactory { //TODO: Anonymous classes created for test purposes
    static final ImmutableMap<Shop, ShopParser> SHOPS = new ImmutableMap.Builder<Shop,ShopParser>()
            .put(SUPERNOVABOTS, new SupernovaParser())
            .put(CLANTEAM, new ClanTeamParser())
            .build();
    public ShopParser getShopParser(Shop shop){
        return SHOPS.get(shop);
    }
}
