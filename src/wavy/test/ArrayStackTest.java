package wavy.test;

import wavy.util.dsa.Stack.ArrayStack;

/**
 * ArrayStack测试类
 * Created by WavyPeng on 2018/7/2.
 */
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