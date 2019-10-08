package Testing;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {

    @Test(expected = ArithmeticException.class)
    public void checkZeroShouldThrowException() {
       MyMath.devide(3,0);
    }
}