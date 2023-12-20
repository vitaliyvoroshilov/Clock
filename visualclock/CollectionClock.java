package com.example.visualclock;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionClock implements Iterable<IClock>, Iterator<IClock> {
    ArrayList<IClock> listOfClocks;
    HashSet<Double> setOfPrices;
    HashSet<String> setOfBrands;
    HashMap<String, Integer> mapOfBrandFrequences;

    ArrayList<IObserver> allObservers;

    public CollectionClock() {
        this.listOfClocks = new ArrayList<>();
        this.setOfPrices = new HashSet<>();
        this.setOfBrands = new HashSet<>();
        this.mapOfBrandFrequences = new HashMap<>();

        this.allObservers = new ArrayList<>();
    }

    void events() {
        for (IObserver obs : allObservers)
            obs.event(this);
    }

    public void sub(IObserver obs) {
        this.allObservers.add(obs);
    }

    public void add(IClock clock) {
        listOfClocks.add(clock);
        setOfPrices.add(clock.getPrice());
        setOfBrands.add(clock.getBrand());
        if (!mapOfBrandFrequences.containsKey(clock.getBrand()))
            mapOfBrandFrequences.put(clock.getBrand(), 0);
        else
            mapOfBrandFrequences.put(clock.getBrand(), mapOfBrandFrequences.get(clock.getBrand()) + 1);
        events();
    }

    public void remove(IClock clock) {
        listOfClocks.remove(clock);
        if (mapOfBrandFrequences.containsKey(clock.getBrand()))
            if (mapOfBrandFrequences.get(clock.getBrand()) == 1)
                mapOfBrandFrequences.remove(clock.getBrand());
            else
                mapOfBrandFrequences.put(clock.getBrand(), mapOfBrandFrequences.get(clock.getBrand()) - 1);
        events();
    }

    @Override
    public Iterator<IClock> iterator() {
        return listOfClocks.iterator();
    }

    @Override
    public boolean hasNext() {
        return listOfClocks.iterator().hasNext();
    }

    @Override
    public IClock next() {
        return listOfClocks.iterator().next();
    }

    public void setTimeAll(TypeTime type, int time) throws InvalidTime {
        for (IClock clock : listOfClocks) {
            clock.setTime(type, time);
        }
    }

    public IClock getMostExpensive() {
        double maxPrice = -1;
        for (double price : setOfPrices) {
            if (price > maxPrice)
                maxPrice = price;
        }
        for (IClock clock : listOfClocks) {
            if (clock.getPrice() == maxPrice)
                return clock;
        }
        return listOfClocks.get(0);
    }

    public String getMostFrequentBrand() {
        int maxFrequency = -1;
        for (IClock clock: listOfClocks) {
            if (mapOfBrandFrequences.get(clock.getBrand()) > maxFrequency)
                maxFrequency = mapOfBrandFrequences.get(clock.getBrand());
        }

        String res = "";
        for (String brand : setOfBrands) {
            if (mapOfBrandFrequences.get(brand) == maxFrequency)
                res += brand + " ";
        }
        return res;
    }

    public String getAllSortedBrands() {
        TreeSet<String> treeSetOfBrands = new TreeSet<>();
        treeSetOfBrands.addAll(setOfBrands);
        String res = "";
        for (String brand: treeSetOfBrands)
            res += brand + " ";
        return res;
    }
}