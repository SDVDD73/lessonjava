package Thread.ThreadSynchronTest.voltage;

import java.util.Scanner;

public class ThreadSinhronTest {
    public static void main(String[] args) {

        MyThreadTest myThreadTest = new MyThreadTest();
        myThreadTest.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThreadTest.shutdown();

    }
}

class MyThreadTest extends Thread{

    private volatile boolean running = true;

    @Override
    public void run(){
        while(running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        this.running = false;
    }
}
