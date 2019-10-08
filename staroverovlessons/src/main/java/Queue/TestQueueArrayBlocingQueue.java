package Queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TestQueueArrayBlocingQueue {
    public static void main(String[] args) {

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);
        Person person6 = new Person(6);

        Queue<Person> peoples = new ArrayBlockingQueue<Person>(5); //обязательно указать в конструкторе сколько будет элементов очереди

        System.out.println(peoples.peek() + "\r\n"); //Достанем человека из очереди

        peoples.add(person3);
        peoples.add(person2);
        peoples.add(person4);
        peoples.add(person5);
        peoples.add(person6);

        //persn3 <- person2 <- person4 <- person1

        System.out.println(peoples.remove() + "\r\n"); //Достанем и удалим из очереди первого вошедшего (тут будет person3). Вначале достает элемент(с ним можно поработать), а только потом удалит его из очереди

        peoples.forEach(people -> System.out.println(people));

        System.out.println(peoples.peek() + "\r\n"); //Достанем человека из очереди

        peoples.forEach(people -> System.out.println(people));

        //peoples.forEach(people -> System.out.println(people));
    }

    //add | offer
    //element | peek
    //remove | poll  различия в том, что методы из первого столба вызовут исключение в случае невозможности выполнения метода,
    // а из второго столба просто вернут null(не вызвав крах проги)
}




