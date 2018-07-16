package wavy.util.dsa.Queue;

import wavy.util.dsa.Array.Array;

/**
 * ArrayQueue
 * 基于Array动态数组实现的队列
 * @param <E>
 * Created by WavyPeng on 2018/7/2.
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    /**
     * 构造器
     * @param capacity
     */
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 默认构造器
     */
    public ArrayQueue(){
        array = new Array<>();
    }

    /**
     * 获取队列容量
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 将队列转换成字符串格式输出
     * @return
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Queue: ");
        ret.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            ret.append(array.get(i));
            if(i != array.getSize() - 1)
                ret.append(", ");
        }
        ret.append("] tail");
        return ret.toString();
    }
}