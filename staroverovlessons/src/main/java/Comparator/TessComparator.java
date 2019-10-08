package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TessComparator {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("dog");
        animals.add("cat");
        animals.add("a");
        animals.add("nn");
        animals.add("frog");
        animals.add("bird");
        animals.add("aaaaaaaaaa");

        Collections.sort(animals, new StringLenghtComparator());
        System.out.println(animals.toString());

        Collections.sort(animals, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(animals.toString());

        Collections.sort(animals, (o1, o2) -> o1.compareTo(o2));
        System.out.println(animals.toString());

        Collections.sort(animals);
        System.out.println(animals.toString());

        animals.sort(Comparator.comparing(e -> e.length()));
        System.out.println(animals.toString());

        animals.sort(Comparator.comparing(e -> e.length() * -1));
        System.out.println(animals.toString());



        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(10);

        Collections.sort(numbers, new IntComparator());
        System.out.println(numbers.toString());

        Collections.sort(numbers);
        System.out.println(numbers.toString());


    }
}
