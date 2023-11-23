package Lab23;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionClock implements Iterable<IClock>, Iterator<IClock> {
    ArrayList<IClock> listOfClocks;
    HashSet<Double> setOfPrices;
    HashSet<String> setOfBrands;
    HashMap<String, Integer> mapOfFrequences;

    public CollectionClock() {
        this.listOfClocks = new ArrayList<>();
        this.setOfPrices = new HashSet<>();
        this.setOfBrands = new HashSet<>();
        this.mapOfFrequences = new HashMap<>();
    }

    public void add(IClock clock) {
        listOfClocks.add(clock);
        setOfPrices.add(clock.getPrice());
        setOfBrands.add(clock.getBrand());
        if (!mapOfFrequences.containsKey(clock.getBrand()))
            mapOfFrequences.put(clock.getBrand(), 0);
        else
            mapOfFrequences.put(clock.getBrand(), mapOfFrequences.get(clock.getBrand()) + 1);
    }

    public void remove(IClock clock) {
        listOfClocks.remove(clock);
        if (mapOfFrequences.get(clock.getBrand()) == 1)
            mapOfFrequences.remove(clock.getBrand());
        else
            mapOfFrequences.put(clock.getBrand(), mapOfFrequences.get(clock.getBrand()) - 1);
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

    public void getMostExpensive() {
        double maxPrice = -1;
        for (double price : setOfPrices) {
            if (price > maxPrice)
                maxPrice = price;
        }
        for (IClock clock : listOfClocks) {
            if (clock.getPrice() == maxPrice)
                System.out.println("getMostExpensive: " + clock.toString());
        }
    }

    public void getMostFrequent() {
        int maxFrequency = -1;
        for (IClock clock: listOfClocks) {
            if (mapOfFrequences.get(clock.getBrand()) > maxFrequency)
                maxFrequency = mapOfFrequences.get(clock.getBrand());
        }
        for (IClock clock : listOfClocks) {
            if (mapOfFrequences.get(clock.getBrand()) == maxFrequency)
                System.out.println("getMostFrequent: " + clock.toString());
        }
    }

    public void getAllSortedBrands() {
        //setOfBrands.toArray()[0] = 1;
        for (String brand: setOfBrands)
            System.out.println("getAllSortedBrands: " + brand);
    }
}