package com.example.visualclock;

public interface IClock {

    public void setTime(TypeTime type, int time) throws InvalidTime;

    public int getTime(TypeTime type);

    public String getBrand();
    public double getPrice();

    public TypeClock getType();

    @Override
    public String toString();
}