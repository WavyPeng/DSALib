package wavy.util.dsa;

/**
 * 二分搜索树（不包含重复元素）
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

    /**
     * 插入元素
     * @param e
     */
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 返回插入新节点后二叉搜索树的根
     * @param node
     * @param e
     */
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }
}
