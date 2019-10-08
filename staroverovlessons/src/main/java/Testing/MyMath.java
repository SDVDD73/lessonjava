package Testing;

public class MyMath {
        public static double devide(int numberOne, int numberTwo){

            if(numberTwo == 0)
                throw new ArithmeticException("Нельхя делить на 0");

            return numberOne/numberTwo;
        }
}
