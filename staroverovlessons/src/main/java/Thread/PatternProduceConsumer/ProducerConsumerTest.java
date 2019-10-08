package Thread.PatternProduceConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Очередь из нескольких потоков, выполнять в очереди определённое количество потоков
//Один поток накидывает задачи
//Второй поток решает задачи
public class ProducerConsumerTest {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);//очередь FIFO, очередь из 10 элементов

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();

        while(true){
            System.out.println("Зашел закрыть место в потоке");
            blockingQueue.put(random.nextInt(100));

        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while(true){
            Thread.sleep(100);

            if(random.nextInt(10) == 5) {
                System.out.println("Зашел освободить место в потоке");
                System.out.println("take: " + blockingQueue.take());          //!!!!!!!!!!!!!
                System.out.println("Размер очереди: " + blockingQueue.size());
            }
        }
    }
}
