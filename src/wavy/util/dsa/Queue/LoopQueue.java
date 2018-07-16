package wavy.util.dsa.Queue;

/**
 * 循环队列
 * Created by WavyPeng on 2018/7/2.
 */
public class LoopQueue<E> implements Queue<E> {

    /**基本数组 */
    private E[] data;
    /**队首 */
    private int front;
    /**队尾 */
    private int tail;
    /**队列中元素个数 */
    private int size;

    /**
     * 构造器
     * @param capacity 容量
     */
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 默认构造器
     */
    public LoopQueue(){
        this(10);
    }

    /**
     * 数组容量
     * @return
     */
    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * 进队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 队满扩容
        if((tail+1)%data.length==front)
            resize(2 * getCapacity());
        data[tail] = e;
        tail = (tail + 1)%data.length;
        size++;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        // 缩容
        if(size == (getCapacity() >> 2) && (getCapacity() >> 1) !=0 )
            resize(getCapacity() >> 1);
        return ret;
    }

    /**
     * 获取队首元素
     * @return
     */
    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    /**
     * 获取队列中元素个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 将队列转换成字符串输出
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * 扩容 or 缩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];
        for(int i=0;i<size;i++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }
}
