package com.mycompany.clock;

public class MinuteClock implements IClock {
    protected int hour, minute;
    protected String brand;
    protected double price;

    public MinuteClock (){
        brand = "emptyBrand";
        price = 0.0;
        hour = minute = 0;
    }
    public MinuteClock (String brand, double price, int hour, int minute) throws InvalidTime{
        this.brand = brand;
        this.price = price;
        if (hour < 0 || hour > 24 || minute < 0 || minute > 60)
            throw new InvalidTime();
        this.hour = hour;
        this.minute = minute;
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
        }
    }

    @Override
    public int getTime(TypeTime type){
        switch(type){
            case Hour:
                return this.hour;
            case Minute:
                return this.minute;
        }
        return 0;
    }

    @Override
    public String getBrand(){
        return brand;
    }
    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public String toString()
    {
        return "(" + brand + ", " + price + ", " + hour + ":" + minute + ")";
    }
}