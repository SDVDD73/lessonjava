package Thread.ThreadTest;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
       // myThread.run(); //просто запустить метод run
        myThread.start(); //запустит в потоке то, что находится в методе run

        MyThread myThread12 = new MyThread();
        myThread12.start();

        Thread thread = new Thread(new Runner());
        thread.start();

        System.out.println("ddgdgdg");
    }
}

class MyThread extends Thread{

    int number;
    static int counter;

    MyThread(){
        number = counter;
        counter++;
    }

    public void run(){
        for(int i = 0; i < 1000; i++){
            System.out.println("Hello from MyThread[" + number + "] " + i);
        }
    }

}

class Runner implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            System.out.println("Hello from MyThread "  + i);
        }
    }
}
