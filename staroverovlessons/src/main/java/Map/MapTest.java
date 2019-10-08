package Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1,"Один");
        map.put(2,"Два");
        map.put(3,"Три");
        map.put(4,"Четыре");
        map.put(5,"Пять");
        map.put(6,"Три");

//        System.out.println(map);
//
//        map.put(3,"Другое значение для ключа 3");
//
//        System.out.println(map);
//
//        System.out.println(map.get(1));
//        System.out.println(map.get(10));

        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }



    }
}
