package com.mtgprofit.core.model.shopparser;

import com.mtgprofit.core.model.Expansion;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mtgprofit.core.model.Expansion.*;

public class SupernovaParserTest {
    @Test
    public void testName() throws Exception {
        SupernovaParser parser = getTestParser();
        List<Expansion> expansions= getExpansionList(DTK, KTK);
        parser.getCards(expansions,new BigDecimal(1));
    }

    private List<Expansion> getExpansionList(Expansion... expansions) {
        List<Expansion> expansionList = new ArrayList<>();
        Collections.addAll(expansionList, expansions);
        return  expansionList;
    }

    private SupernovaParser getTestParser() {
        return new SupernovaParser(){
            @Override
            protected String getAddress() {
                return new File("src/test/resources/supernova.txt").toURI().toString();
            }
        };
    }
}