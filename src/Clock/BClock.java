package Clock;

public class BClock {
    static public IClock build(TypeClock type, String name, double price, int hour, int minute, int second) throws InvalidTime{
        switch (type){
            case MinuteClock:
                return new MinuteClock(name, price, hour, minute);
            case SecondClock:
                return new SecondClock(name, price, hour, minute, second);
        }
        return null;
    }
}
