package Testing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Пример теста на выполнение метода за опредлённое время
 * */
public class NetworkUtilsTest {

    @Test(timeout = 1000)
    public void getConnectionShouldReturnFasterThanOneSecond(){
        NetworkUtils.getConnection();
    }
}