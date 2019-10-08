package Thread.CountDownLacth;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Защедка обратного отсчёта
 */
public class CountDownLacthTest2 {
    public static void main(String[] args) throws InterruptedException {

        //При создании объекта нужно указать количество итерации, которые мы должны отсчитать назад прежде, чем защелка отопрется
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++){
            executorService.submit(new Processor2(i, countDownLatch));
        }

        executorService.shutdown();

        for(int i = 0; i < 3; i++){
            Thread.sleep(1000);
            countDownLatch.countDown();
        }



        System.out.println("Latch has been opened, main thread is processing");

    }
}

class Processor2 implements Runnable{

    private CountDownLatch countDownLatch;
    private int id;

    //Каждому классу будем передавать объект CountDownLacth, от него уже будем плясать. Он потокобезопасен
    //поэтому синхронизировать методы будет проще
    public Processor2(int id, CountDownLatch countDownLatch){

        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread with id " + id + " processed");
    }
}