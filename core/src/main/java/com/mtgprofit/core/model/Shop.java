package com.mtgprofit.core.model;

/**
 * Created by wawszcza on 7/27/2015.
 */
public enum Shop {
    SUPERNOVABOTS("SupernovaBots", "http://supernovabots.com/prices_0.txt"),
    CLANTEAM("ClanTeam", "http://mtgoclanteam.com/Cards?edition=%s");
    private String name;
    private String address;

    private Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
