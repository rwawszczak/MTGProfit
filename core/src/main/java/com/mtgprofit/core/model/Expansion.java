package com.mtgprofit.core.model;

/**
 * Created by wawszcza on 7/27/2015.
 */
public enum Expansion {
    ORI("ORI","Magic Origins"),
    DTK("DTK","Dragons of Tarkir"),
    FRF("FRF","Fate Reforged"),
    KTK("KTK","Khans of Tarkir"),
    M15("M15","Magic 2015"),
    JOU("JOU","Journey into Nyx"),
    BNG("BNG","Born of the Gods"),
    THS("THS","Theros"),
    MM2("MM2","Modern Masters 2015"),
    TPR("TPR","Tempest Remastered"),
    VMA("VMA","Vintage Masters"),
    MMA("MMA","Modern Masters"),
    M14("M14","Magic 2014"),
    DGM("DGM","Dragon's Maze"),
    GTC("GTC","Gatecrash"),
    RTR("RTR","Return to Ravnica"),
    M13("M13","Magic 2013"),
    AVR("AVR","Avacyn Restored"),
    DKA("DKA","Dark Ascension"),
    ISD("ISD","Innistrad");

    String[] names;

     Expansion(String... names) {
         this.names=names;
    }

    public String[] getNames() {
        return names;
    }

    public static Expansion getExpansion(String name){
        for(Expansion e : Expansion.values())
            for(String n : e.getNames())
                if(name.equals(n))
                    return e;
        return null;
    }
}
