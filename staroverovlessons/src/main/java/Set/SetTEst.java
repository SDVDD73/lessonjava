package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTEst {
    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        testHashSet(hashSet);

        testHashSet(linkedHashSet);

        testHashSet(treeSet);


        System.out.println(hashSet.contains("Петя"));
        System.out.println(hashSet.contains("Петька"));

    }

    private static void testHashSet(Set<String> hashSet) {
        hashSet.add("Петька");
        hashSet.add("Вастка");
        hashSet.add("Коля");
        hashSet.add("Иван");
        hashSet.add("Виктория");
        hashSet.add("Иван");

        for(String name : hashSet){
            System.out.println(name);
        }

        System.out.println();
    }
}
