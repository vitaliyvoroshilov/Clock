package Lab23;

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
    public void setTime(TypeTime type, int time) throws InvalidTime {
        switch(type){
            case Hour:
                if (time < 0 || time > 24)
                    throw new  IllegalArgumentException();
                this.hour = time;
            case Minute:
                if (time < 0 || time > 60)
                    throw new  IllegalArgumentException();
                this.minute = time;
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
    public String getName(){
        return name;
    }
    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public String toString()
    {
        return name + " " + price + " " + hour + ":" + minute;
    }
}
