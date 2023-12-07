package com.mycompany.clock;

public class InvalidTime extends Exception{
    @Override
    public String toString() {
        return "InvalidTime";
    }
}