package Thread.ReentrantLook;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Помогает лучше синхронизовать потоки
 */
public class ReentnantLockTest {
    public static void main(String[] args) throws InterruptedException {


        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        /*Thread thread2 = new Thread(() -> {
            task.secondThread();
        });*/

        Thread thread2 = new Thread(task::secondThread);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showConter();
    }
}

class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }

    public void showConter(){
        System.out.println("Conter " + counter);
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }


}