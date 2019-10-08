package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueueLinkedList {
    public static void main(String[] args) {

        //LinkedList использует модель FIFO first-in-first-out

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        Queue<Person> peoples = new LinkedList<>();

        peoples.add(person3);
        peoples.add(person2);
        peoples.add(person4);
        peoples.add(person1);

        //persn3 <- person2 <- person4 <- person1

        peoples.forEach(people -> System.out.println(people));





    }
}

