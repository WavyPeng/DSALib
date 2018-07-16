package wavy.test;

import wavy.util.dsa.Queue.LoopQueue;

/**
 * LoopQueue测试类
 * Created by WavyPeng on 2018/7/2.
 */
public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
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