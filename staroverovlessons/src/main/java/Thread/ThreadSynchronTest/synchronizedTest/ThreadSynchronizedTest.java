package Thread.ThreadSynchronTest.synchronizedTest;

public class ThreadSynchronizedTest {
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadSynchronizedTest threadSynchronizedTest = new ThreadSynchronizedTest();

        threadSynchronizedTest.doWork();

    }

    private void  increment() {
        synchronized (this){
            counter++;
        }
    }

    /*//Тоже самое, что и выше, так как при такой записи сихнонизация просходит в объекте this
    private synchronized void increment() {
        counter++;
    }*/

    public void doWork() throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        thread1.start();//Начнём поток
        thread2.start();

        thread1.join();//Дождемся конца потока
        thread2.join();

        System.out.println(counter);
    }



}
