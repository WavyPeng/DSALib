package wavy.util.dsa;

/**
 * 栈接口
 * Created by WavyPeng on 2018/7/2.
 */
public interface Stack<E> {
    /**
     * 压栈
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();

    /**
     * 获取栈的尺寸
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
}