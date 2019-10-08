package Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterable {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();


       /* while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
       System.out.println();
       */


        int index = 0;
        //Before java 1.5 итератор устарел, зато в неё можно удалять элементы списка. Обрати внимание на то, что если пробежка
        // по итератору была сделана уже выше, повторно в него больше не зайдёт(раскоменть код и запусти программу, увидишь
        // изменение - ничего не кдалится, так как по итератору уже сделаны все шаги). Для обхода этого необходимо заного задать
        // экземпляр итератора
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            if (index == 2)
                iterator.remove();

            index++;
        }

        System.out.println();

        System.out.println(list);

        System.out.println();


        //java 1.5
        for (int item : list) {
            System.out.println(item);
        }


    }
}
