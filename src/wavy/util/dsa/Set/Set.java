package wavy.util.dsa.Set;
/**
 * 集合接口
 * Created by WavyPeng on 2018/7/16.
 */
public interface Set<E> {
    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    /**
     * 删除元素
     * @param e
     */
    void remove(E e);

    /**
     * 是否包含某元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 集合大小
     * @return
     */
    int getSize();

    /**
     * 判空
     * @return
     */
    boolean isEmpty();
}