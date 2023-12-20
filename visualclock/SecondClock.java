package com.example.visualclock;

public class SecondClock extends MinuteClock implements IClock{
    public int second;

    public SecondClock(){
        hour = minute = second = 0;
        brand = "emptyBrand";
        price = 0.0;
    }
    public SecondClock (String brand, double price, int hour, int minute, int second) throws InvalidTime{
        this.brand = brand;
        this.price = price;
        if (hour < 0 || hour > 24 || minute < 0 || minute > 60 || second < 0 || second > 60)
            throw new IllegalArgumentException();
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public void setTime(TypeTime type, int time) throws InvalidTime {
        switch(type){
            case Hour:
                if (time < 0 || time > 24)
                    throw new  IllegalArgumentException();
                this.hour = time;
                break;
            case Minute:
                if (time < 0 || time > 60)
                    throw new  IllegalArgumentException();
                this.minute = time;
                break;
            case Second:
                if (time < 0 || time > 60)
                    throw new  IllegalArgumentException();
                this.second = time;
                break;
        }
    }

    @Override
    public int getTime(TypeTime type){
        switch(type){
            case Hour:
                return this.hour;
            case Minute:
                return this.minute;
            case Second:
                return this.second;
        }
        return 0;
    }

    @Override
    public TypeClock getType() {
        return TypeClock.SecondClock;
    }

    @Override
    public String toString()
    {
        return "(" + brand + ", " + price + ", " + hour + ":" + minute + ":" + second + ")";
    }
}
