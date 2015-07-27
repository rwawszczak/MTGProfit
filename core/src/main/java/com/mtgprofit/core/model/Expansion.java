package com.mtgprofit.core.model;

/**
 * Created by wawszcza on 7/27/2015.
 */
public enum Expansion {
    DKT("DKT", "Dragons of Tarkir"), FRF("FRF","Fate Reforged"), KTK("KTK","Khans of Tarkir"), VM("VM","Vintage Masters");

    String[] names;

     Expansion(String... names) {
         this.names=names;
    }
}
