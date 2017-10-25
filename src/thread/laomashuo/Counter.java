package thread.laomashuo;

public class Counter {
    private int count = 0;

    public synchronized void incr() {
        count ++;
    }

    public synchronized int getCounter() {
        return count;
    }
}
