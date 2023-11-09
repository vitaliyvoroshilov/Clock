package Lab23;

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
            case Second:
                if (time < 0 || time > 60)
                    throw new  IllegalArgumentException();
                this.second = time;
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
    public String toString()
    {
        return name + " " + price + " " + hour + ":" + minute + ":" + second;
    }
}