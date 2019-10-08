package Thread.ThreadSynchronTest.synchronizedBlockTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadSynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();

        worker.main();
    }
}

class Worker {

    private Random random = new Random();

    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> integerList1 = new ArrayList<>();
    private List<Integer> integerList2 = new ArrayList<>();

    public void addToList1(){
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            integerList1.add(random.nextInt());
        }
    }

    public void addToList2(){
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            integerList2.add(random.nextInt());
        }
    }

    public void work(){
        for(int i = 0; i < 1000; i++){
            addToList1();
            addToList2();
        }

    }

    public void main() throws InterruptedException {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long after = System.currentTimeMillis();

        System.out.println("Program took " + (after - before) + " ms to run");

        System.out.println("List1: "  + integerList1.size());
        System.out.println("List2: "  + integerList2.size());

    }
}
