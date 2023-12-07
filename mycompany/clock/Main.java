package com.mycompany.clock;

public class Main {
    public static void main(String[] args) throws InvalidTime{

        CollectionClock shopClock = new CollectionClock();

        IClock minClock1 = BClock.build(TypeClock.MinuteClock, "Tissot", 100.0, 1, 59, 0);
        IClock minClock2 = BClock.build(TypeClock.MinuteClock, "Casio", 150.0, 2, 59, 0);
        IClock secClock1 = BClock.build(TypeClock.SecondClock, "Epson", 250.0, 3, 59, 59);
        IClock secClock2 = BClock.build(TypeClock.SecondClock, "Rolex", 300.0, 4, 59, 59);
        IClock secClock3 = BClock.build(TypeClock.SecondClock, "Tissot", 200.0, 5, 59, 59);

        shopClock.add(minClock1);
        shopClock.add(secClock1);
        shopClock.add(minClock2);
        shopClock.add(secClock2);
        shopClock.add(secClock3);

        System.out.println("Most expensive: " + shopClock.getMostExpensive());
        System.out.println("Most frequent brand: " + shopClock.getMostFrequentBrand());
        System.out.println("All sorted brands: " + shopClock.getAllSortedBrands());

        shopClock.setTimeAll(TypeTime.Minute, 10);

        System.out.println();
        for (IClock iClock : shopClock) {
            System.out.println(iClock.toString());
        }
    }
}