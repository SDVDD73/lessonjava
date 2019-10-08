package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapAndTreeMap {
    public static void main(String[] args) {

        Map<Integer, String> hashmap = new HashMap<>();//Внутри не гарантируется никакого порядка

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();// В каком порядке пары ключ значения добавлены в таком и вернутся

        Map<Integer, String> treeMap = new TreeMap<>();//Пары ключ значение отсортированы по ключу

        testMap(hashmap);

        testMap(linkedHashMap);

        testMap(treeMap);


    }


    public static void testMap(Map<Integer, String> map){

        map.put(39, "Петя");
        map.put(145, "Вася");
        map.put(0, "Коля");
        map.put(1000, "Даня");
        map.put(65, "Алексей");
        map.put(11, "Павел");
        map.put(145054, "Вася");

        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println();
    }
}
