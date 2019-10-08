package Testing;


public class NetworkUtils {
    public static void getConnection(){

        //Получаем соединение с сервером sleep типо имитация работы соединения в секундах
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;

    }
}
