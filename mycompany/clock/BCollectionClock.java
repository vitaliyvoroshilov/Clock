package com.mycompany.clock;

public class BCollectionClock {
    static CollectionClock colClock = new CollectionClock();

    public static CollectionClock build() {
        return colClock;
    }
}
