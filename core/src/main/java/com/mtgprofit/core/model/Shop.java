package com.mtgprofit.core.model;

/**
 * Created by wawszcza on 7/27/2015.
 */
public enum Shop {
    SUPERNOVABOTS("http://supernovabots.com/prices_0.txt");
    private String address;

    private Shop(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
