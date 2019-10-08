package Testing;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2DTest {

    @Test
    public void newVectorShouldHaveZeroLenght(){
        Vector2D v1 = new Vector2D(); //action действие

        //assertion проверим ожидаемый результат
        //первый параметр - что мы ждём, второй - выполнение метода, то, что даст нам метод, третий - точность
        Assert.assertEquals(0, v1.lenght(), 1e-5);
    }

    @Test
    public void newVectorShouldHaveZeroX(){
        Vector2D v1 = new Vector2D();

        Assert.assertEquals(0, v1.getX(), 1e-5);
    }

    @Test
    public void newVectorShouldHaveZeroY(){
        Vector2D v1 = new Vector2D();

        Assert.assertEquals(0, v1.getY(), 1e-5);
    }



}