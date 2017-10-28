package thread.laomashuo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private static AtomicInteger counter = new AtomicInteger();

    static class Visitor extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                counter.incrementAndGet();
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        Thread[] threads = new Thread[num];
        for(int i = 0; i < num; i++) {
            threads[i] = new Visitor();
            threads[i].start();
        }
        for(int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.get());
    }
}
