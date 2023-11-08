package Clock;

public class SecondClock extends MinuteClock implements IClock{
    public int second;

    public SecondClock(){
        hour = minute = second = 0;
        name = "emptyName";
        price = 0.0;
    }
    public SecondClock (String name, double price, int hour, int minute, int second) throws InvalidTime{
        this.name = name;
        this.price = price;
        if (hour < 0 || hour > 24 || minute < 0 || minute > 60 || second < 0 || second > 60)
            throw new IllegalArgumentException();
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public void setSecond(int second) throws InvalidTime {
        if (second < 0 || second > 60)
            throw new IllegalArgumentException();
        this.second = second;
    }

    @Override
    public int getSecond()
    {
        return second;
    }
    @Override
    public String toString()
    {
        return name + " " + price + " " + hour + ":" + minute + ":" + second;
    }
}