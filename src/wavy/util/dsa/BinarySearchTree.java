package wavy.util.dsa;

/**
 * 二分搜索树
 * Created by WavyPeng on 2018/7/5.
 */
public class BinarySearchTree<E extends Comparable<E>> {

    /**节点类型 */
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**根节点 */
    private Node root;
    private int size;

    /**
     * 默认构造器
     */
    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    /**
     * 获取树的大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }
}
