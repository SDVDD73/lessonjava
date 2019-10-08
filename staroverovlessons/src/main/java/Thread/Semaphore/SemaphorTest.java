package Thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Семафор используется если у нас есть ресурс и много потоков использует этот ресурс, и мы хотим это ограничить
 * Пример:
 * Есть сервер(ресурс) и многие пользователи хотят отправлять запросы в этот ресурс
 * Но пропускная способность интернета ограничена, значит и это нужно ограничивать
 *
 *         Semaphore semaphore = new Semaphore(3); //В конструктор пишем сколько потоков одновремнно могут отправлять данные на сервер(использовать какаой-то ресурс)
 *         semaphore.acquire();//Вызывать, когдам метод начинает взаимодействовать с потоком
 *         semaphore.release();//Даем понять семафору, что один блок освободился
 *         semaphore.availablePermits();//Возвращает количество разрешений
 */
public class SemaphorTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        Connection connection = Connection.getConnection();
        for(int i = 0; i < 1000; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {
    private static Connection connection = new Connection();
    private int connectionCounts;
    Semaphore semaphore = new Semaphore(7); //В конструктор пишем сколько потоков одновремнно могут отправлять данные на сервер(использовать какаой-то ресурс)

    private Connection(){

    }

    public static Connection getConnection(){
        return connection;
    }

    public void work() throws InterruptedException {
        try{
            semaphore.acquire();
            doWork();
        }finally {
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException{
        synchronized (this){
            connectionCounts++;
            System.out.println(connectionCounts);
        }

        Thread.sleep(2000);

        synchronized (this){
            connectionCounts--;
        }
    }
}
