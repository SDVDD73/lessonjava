package Thread.PatternProduceConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerCustom {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;


    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                if (queue.size() == LIMIT) {
                    lock.wait();
                }
                System.out.println("Queue size: " + queue.size());
                queue.offer(++value);
                lock.notify();
            }
        }

    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }

                int value = queue.poll();
                System.out.println(value);
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}