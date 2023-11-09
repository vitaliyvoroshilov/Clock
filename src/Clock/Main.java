package Lab23;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvalidTime{

        ArrayList<IClock> collectionClock = new ArrayList<>();

        IClock minClock1 = BClock.build(TypeClock.MinuteClock, "minClock1", 1.0, 23, 59, 0);
        System.out.println(minClock1.toString());
        minClock1.setTime(TypeTime.Hour, 1);
        minClock1.setTime(TypeTime.Minute, 1);
        collectionClock.add(minClock1);

        IClock secClock1 = BClock.build(TypeClock.SecondClock, "secClock1", 2.0, 23, 59, 59);
        System.out.println(secClock1.toString());
        secClock1.setTime(TypeTime.Hour, 2);
        secClock1.setTime(TypeTime.Minute, 2);
        secClock1.setTime(TypeTime.Second, 2);
        collectionClock.add(secClock1);

        System.out.println();

        for (IClock iClock : collectionClock) {
            System.out.println(iClock.toString());
        }
    }
}
