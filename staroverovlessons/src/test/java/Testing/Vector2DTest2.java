package Testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Пример теста сопостановления значений
 * @BegoreClass - надо создавать статическим, отработает один раз перед тестами
 *
 * @Before - отработает перед каждом методои
 *
 * @Test - совершить тестовый сценарий
 *
 * @Alter - Отработает после каждого метода
 *
 * @AlterClass - отработает после выполнения всех тестов один раз
 * */

public class Vector2DTest2 {
    private final double EPS = 1e-9;
    private Vector2D v1;

    @Before
    public void createNewVector(){
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLenght(){
        //assertion проверим ожидаемый результат
        //первый параметр - что мы ждём, второй - выполнение метода, то, что даст нам метод, третий - точность
        Assert.assertEquals(0, v1.lenght(), 1e-5);
    }

    @Test
    public void newVectorShouldHaveZeroX(){

        Assert.assertEquals(0, v1.getX(), 1e-5);
    }

    @Test
    public void newVectorShouldHaveZeroY(){

        Assert.assertEquals(0, v1.getY(), 1e-5);
    }



}