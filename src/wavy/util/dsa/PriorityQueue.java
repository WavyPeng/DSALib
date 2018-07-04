package wavy.util.dsa;

/**
 * PriorityQueue
 * 基于大顶堆实现的优先队列
 * Created by WavyPeng on 2018/7/4.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    /**
     * 默认构造器
     */
    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * 获取队头元素
     * @return
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    /**
     * 获取队列元素个数
     * @return
     */
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    /**
     * 队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}