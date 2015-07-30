package com.mtgprofit.core.controllers;

import com.google.common.collect.Lists;
import com.mtgprofit.core.model.Expansion;
import com.mtgprofit.core.model.Shop;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wawszcza on 7/24/2015.
 */

@RestController
public class AvailableController {

    @RequestMapping("/shops")
    public List<Shop> shops()
    {
        return Lists.newArrayList(Shop.values());
    }

    @RequestMapping("/expansions")
    public List<Expansion> expansions()
    {
        return Lists.newArrayList(Expansion.values());
    }
}
