package wavy.util.dsa;
/**
 * 集合实现，基于链表
 * Created by WavyPeng on 2018/7/16.
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<E>();
    }

    /**
     * 添加元素
     * @param e
     */
    @Override
    public void add(E e) {
        // 判断是否是重复元素
        if(!list.contains(e))
            list.addFirst(e);
    }

    /**
     * 删除元素
     * @param e
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * 是否包含某元素
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 集合大小
     * @return
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}