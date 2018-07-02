package wavy.test;

import wavy.util.dsa.ArrayStack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack.toString());
        }

        stack.pop();
        System.out.println(stack.toString());
    }
}