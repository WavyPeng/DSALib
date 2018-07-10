package wavy.test;

import wavy.util.dsa.LinkedListStack;

/**
 * 基于链表实现的测试类
 * Created by WavyPeng on 2018/7/10.
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}