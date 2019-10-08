package Stack;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {

        //Stack использует модель LIFO last-in-last-out
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.peek() + " " + stack.toString()); //Смотрим какой элемент извлечётся в случае, если мы хотим его извлечь

        System.out.println(stack.pop() + " " + stack.toString()); //Извлекаем элемент стека, после извлечения этого элемента больше нет в стеке
        System.out.println(stack.pop() + " " + stack.toString());
        System.out.println(stack.pop() + " " + stack.toString());

        System.out.println();

        stack.push(5);
        stack.push(3);
        stack.push(1);

        while(!stack.empty()){
            System.out.println(stack.pop());
        }




    }
}
