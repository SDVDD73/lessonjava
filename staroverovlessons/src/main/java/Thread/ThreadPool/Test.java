package Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2); //Создадим нашу очередь из двух потоков

        for (int i = 0; i < 5; i++) { //У нас есть два рабочих(2 очереди) и им мы накидываем 5 задач
            executorService.submit(new Work(i));
        }
        executorService.shutdown();//говорим, что задачи мы им накидали и больше кидать не будем


        System.out.println("All task submited");


        //скажем, что у рабочих есть день на выполнение,
        //если они не выполнили, то потоки закрываются и идут дальше
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Work implements Runnable {

    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work " + id + " was complited");
    }
}