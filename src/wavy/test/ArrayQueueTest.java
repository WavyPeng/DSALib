package wavy.test;

import wavy.util.dsa.Queue.Queue.ArrayQueue;

/**
 * ArrayQueue测试类
 * Created by WavyPeng on 2018/7/2.
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue.toString());

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue.toString());
            }
        }
    }
}