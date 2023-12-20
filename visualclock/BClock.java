package com.example.visualclock;

public class BClock {
    static public IClock build(TypeClock type, String brand, double price, int hour, int minute, int second) throws InvalidTime {
        switch (type){
            case MinuteClock:
                return new MinuteClock(brand, price, hour, minute);
            case SecondClock:
                return new SecondClock(brand, price, hour, minute, second);
        }
        return null;
    }
}