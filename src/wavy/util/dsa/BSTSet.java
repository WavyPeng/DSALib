package wavy.util.dsa;
/**
 * 集合实现
 * 基于二分搜索树
 * Created by WavyPeng on 2018/7/16.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BinarySearchTree<E> bst;

    public BSTSet(){
        bst = new BinarySearchTree<E>();
    }

    /**
     * 添加元素
     * @param e
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * 删除元素
     * @param e
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * 是否包含某元素
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    /**
     * 集合大小
     * @return
     */
    @Override
    public int getSize() {
        return bst.size();
    }

    /**
     * 判空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}