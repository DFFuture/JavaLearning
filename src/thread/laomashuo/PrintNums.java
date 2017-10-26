package thread.laomashuo;

public class PrintNums implements Runnable {

    private volatile static int counter = 1;
    private int id = 0;

    public PrintNums(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        while(counter <= 100) {
            if(counter%2 == id) {
                System.out.println(counter);
                counter++;
            }
        }

    }

    public static void main(String[] args) {
        Thread thread0 = new Thread(new PrintNums(0));
        Thread thread1 = new Thread(new PrintNums(1));
        thread0.start();
        thread1.start();
    }
}
