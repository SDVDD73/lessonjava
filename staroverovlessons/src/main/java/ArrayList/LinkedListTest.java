package ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<Integer>();
        List<Integer> arrayList = new ArrayList<>();


        createList(linkedList, 100000);
        createList(arrayList, 100000 );

    }


    private static void createList(List<Integer> list, int leght){
        long start = System.currentTimeMillis();

        for(int index = 0; index < leght; index++){
            list.add( 0 ,index);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }




}
