package com.mtgprofit.core.model.shopparser;

import com.google.common.collect.ImmutableMap;
import com.mtgprofit.core.model.Shop;
import com.mtgprofit.core.model.shopparser.parsers.SupernovaParser;
import com.mtgprofit.core.model.shopparser.parsers.ClanTeamParser;

import java.io.File;

import static com.mtgprofit.core.model.Shop.*;

/**
 * Created by wawszcza on 7/27/2015.
 */
public class ShopParserFactory { //TODO: Anonymous classes created for test purposes
    static final ImmutableMap<Shop, ShopParser> SHOPS = new ImmutableMap.Builder<Shop,ShopParser>()
            .put(SUPERNOVABOTS, new SupernovaParser(){
                @Override
                protected String getAddress() {
                    return new File("src/test/resources/supernova.txt").toURI().toString();
                }
            })
            .put(CLANTEAM, new ClanTeamParser(){
                @Override
                protected String getExpansionAddress(String expansionName) {
                    return new File("src/test/resources/ClanTeamDTK.html").toURI().toString();
                }
            })
            .build();
    public ShopParser getShopParser(Shop shop){
        return SHOPS.get(shop);
    }
}
