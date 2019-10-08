package String;

public class TestString {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Пётр");
        stringBuffer.append(" ");

        System.out.println(stringBuffer);

        String blabla = "bla";

        stringBuffer.append(blabla);
        System.out.println(stringBuffer);

        stringBuffer.delete(stringBuffer.length() - blabla.length(), stringBuffer.length());
        System.out.println(stringBuffer);

        System.out.println(stringBuffer.charAt(3));

        stringBuffer.setCharAt(1, 'Е');
        System.out.println(stringBuffer);

        System.out.println(stringBuffer.subSequence(1, stringBuffer.length()));

        stringBuffer.insert(stringBuffer.length(), "Иванович");
        System.out.println(stringBuffer);

        stringBuffer.insert(0, "Иванов ");
        System.out.println(stringBuffer);


        stringBuffer.reverse();
        System.out.println(stringBuffer);

        reverseStringBuffer(stringBuffer);
        System.out.println(stringBuffer);


    }


    static void reverseStringBuffer(StringBuffer stringBuffer) {

        char cup;
        int indexFirst;
        int indexLast;

        for (int index = 0; index < stringBuffer.length() - 1 >> 1; index++) {

            indexFirst = index;
            indexLast = stringBuffer.length() - index - 1;

            cup = stringBuffer.charAt(stringBuffer.length() - index - 1);

            stringBuffer.setCharAt(indexLast, stringBuffer.charAt(indexFirst));
            stringBuffer.setCharAt(indexFirst, cup);
        }
    }
}
