package Clock;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionClock implements Iterable<IClock>, Iterator<IClock> {
    ArrayList<IClock> listClock;

    public CollectionClock() {
        this.listClock = new ArrayList<>();
    }

    public void add(IClock clock) {
        listClock.add(clock);
    }

    public void remove(IClock clock) {
        listClock.remove(clock);
    }

    @Override
    public Iterator<IClock> iterator() {
        return listClock.iterator();
    }

    @Override
    public boolean hasNext() {
        return listClock.iterator().hasNext();
    }

    @Override
    public IClock next() {
        return listClock.iterator().next();
    }
}