package Thread.CountDownLacth;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Защедка обратного отсчёта
 */
public class CountDownLacthTest1 {
    public static void main(String[] args) throws InterruptedException {

        //При создании объекта нужно указать количество итерации, которые мы должны отсчитать назад прежде, чем защелка отопрется
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++){
            executorService.submit(new Processor1(countDownLatch));
        }

        executorService.shutdown();

        countDownLatch.await();

        System.out.println("Latch has been opened, main thread is processing");

    }
}

class Processor1 implements Runnable{

    private CountDownLatch countDownLatch;
    private int count;
    //Каждому классу будем передавать объект CountDownLacth, от него уже будем плясать.
    public Processor1(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Выполнился раз " + ++count);
        //Дикрементирует состояние потока
        countDownLatch.countDown();
    }
}