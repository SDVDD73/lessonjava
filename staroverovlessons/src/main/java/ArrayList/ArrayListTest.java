package ArrayList;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        int quantityElements = 100;

        for(int index = 0; index < quantityElements; index++){
            arrayList.add(index);
        }

        System.out.println(arrayList);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(arrayList.size()-1));

        arrayList.remove(5);

        System.out.println(arrayList);

    }
}
