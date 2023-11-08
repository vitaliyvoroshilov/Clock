package Clock;

public class MinuteClock implements IClock {
    protected int hour, minute;
    protected String name;
    protected double price;

    public MinuteClock (){
        name = "emptyName";
        price = 0.0;
        hour = minute = 0;
    }
    public MinuteClock (String name, double price, int hour, int minute) throws InvalidTime{
        this.name = name;
        this.price = price;
        if (hour < 0 || hour > 24 || minute < 0 || minute > 60)
            throw new InvalidTime();
        this.hour = hour;
        this.minute = minute;
    }
    @Override
    public void setHour(int hour) throws InvalidTime {
        if (hour < 0 || hour > 24)
            throw new  IllegalArgumentException();
        this.hour = hour;
    }
    @Override
    public void setMinute(int minute) throws InvalidTime {
        if (minute < 0 || minute > 60)
            throw new IllegalArgumentException();
        this.minute = minute;
    }
    @Override
    public void setSecond(int second) throws InvalidTime {}

    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getPrice(){
        return price;
    }
    @Override
    public int getHour()
    {
        return hour;
    }
    @Override
    public int getMinute()
    {
        return minute;
    }
    @Override
    public int getSecond()
    {
        return 0;
    }
    @Override
    public String toString()
    {
        return name + " " + price + " " + hour + ":" + minute;
    }
}