package wavy.util.dsa.Map;
/**
 * 映射接口
 * Created by WavyPeng on 2018/7/16.
 */
public interface Map<K,V> {
    /**
     * 添加元素
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 删除元素
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 判断元素是否存在
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 获取元素
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 设置元素
     * @param key
     * @param value
     */
    void set(K key, V value);

    /**
     * 获取大小
     * @return
     */
    int getSize();

    /**
     * 判空
     * @return
     */
    boolean isEmpty();
}