package Lab23;

public interface IClock {

    public void setTime(TypeTime type, int time) throws InvalidTime;

    public int getTime(TypeTime type) throws InvalidTime;

    public String getName();
    public double getPrice();

    @Override
    public String toString();
}
