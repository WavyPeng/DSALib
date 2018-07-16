package wavy.util.dsa.Queue;
/**
 * 队列接口
 * Created by WavyPeng on 2018/7/2.
 */
public interface Queue<E> {
    /**
     * 进队
     * @param e
     */
    void enqueue(E e);

    /**
     * 队首元素出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();

    /**
     * 队列中元素个数
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();
}