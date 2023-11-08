package Clock;

public interface IClock {

    public void setHour(int hour) throws InvalidTime;
    public void setMinute(int minute) throws InvalidTime;
    public void setSecond(int second) throws InvalidTime;

    public String getName();
    public double getPrice();
    public int getHour();
    public int getMinute();
    public int getSecond();
    @Override
    public String toString();
}
