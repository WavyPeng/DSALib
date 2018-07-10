package wavy.test;

import wavy.util.dsa.LinkedListQueue;
/**
 * 基于链表实现的队列的测试类
 * Created by WavyPeng on 2018/7/10.
 */
public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}