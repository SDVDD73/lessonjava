package EqualsAndHashCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualsAndHashCodeTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        map.put(1, "Один");
        map.put(2, "Другое");
        map.put(3, "Два");
        map.put(1, "Три ");


        set.add(1);
        set.add(1);

        System.out.println(map);
        System.out.println(set);
    } 
}
