package Clock;

public class Main {
    public static void main(String[] args) throws InvalidTime{

        IClock minClock1 = BClock.build(TypeClock.MinuteClock, "minClock1", 1.0, 23, 59, 0);
        System.out.println(minClock1.toString());
        minClock1.setHour(1);
        minClock1.setMinute(1);
        System.out.println(minClock1.toString());

        System.out.println();

        IClock secClock1 = BClock.build(TypeClock.SecondClock, "secClock1", 2.0, 23, 59, 59);
        System.out.println(secClock1.toString());
        secClock1.setHour(2);
        secClock1.setMinute(2);
        secClock1.setSecond(2);
        System.out.println(secClock1.toString());
    }
}