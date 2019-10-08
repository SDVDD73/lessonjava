package Thread.Wait_Notify;

import java.util.Scanner;

public class  Program {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.consume();
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
}

class WaitAndNotify {

    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("producer thead started...");
            wait();//1 - отдаём intrinsic lock, 2 - в текущем потоке ждём будет вызван notify() на этом объекте
            System.out.println("producer thead resume...");
        }

    }

    public void consume()  throws InterruptedException{
        Thread.sleep(1000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("waiting for return key press");
            scanner.nextLine();
            notify();//скажет prodece(у которого вызван метод wait, который ждёт продолжения себя), что пора просыпаться(не ждать),
            //потому что они принадлежат одному контексту (WaitAndNotify в данном случае)
            //монитор перейдёт опять к блоку у которого вызван wain(),
            // когда сам закончится (место показано !!!)

            System.out.println("Ждём пока доработает блок синхронизации");
            Thread.sleep(2000);
        }//(!!!)
    }
}