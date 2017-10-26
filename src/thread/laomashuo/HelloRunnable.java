package thread.laomashuo;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());
        System.out.println("hello");

    }

    public static void main(String[] args) throws InterruptedException{
        Thread helloThread = new Thread(new HelloRunnable());

        helloThread.start();
        helloThread.join();
        System.out.println(Thread.currentThread().getState());
    }
}
