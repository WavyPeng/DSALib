package wavy.util.dsa.Tree;
/**
 * 红黑树
 * Created by WavyPeng on 2018/7/26.
 */
public class RedBlackTree<K extends Comparable<K>,V> {
    /**标记红节点 */
    private static final boolean RED = true;
    /**标记黑节点 */
    private static final boolean BLACK = false;

    /**树节点定义 */
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean color; // 节点颜色

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            // 将新构造节点设置为红色的原因：
            // 从2-3树的角度，每新添一个节点都会和叶节点进行融合
            // 而在红黑树中，红色节点代表它及其父节点在2-3树中是一起的
            color = RED;
        }
    }

    /**根节点 */
    private Node root;
    /**树大小 */
    private int size;

    /**
     * 获取size
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 判断节点颜色
     * 如果树中一个节点为空节点，则将其设置为黑色
     * @param node
     * @return
     */
    private boolean isRed(Node node){
        if(node == null)
            return BLACK;
        return node.color;
    }

    /**
     * 左旋
     * 返回旋转后新的根节点
     * @param node
     * @return
     *
     *     node                 x
     *    /    \              /   \
     *   T1     x     ----> node  T3
     *        /  \         /    \
     *       T2  T3       T1    T2
     */
    private Node leftRotate(Node node){
        Node x = node.right;

        // 左旋
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 右旋
     * 返回旋转后新的根节点
     * @param node
     * @return
     *
     *     node               x
     *    /    \   ---->    /   \
     *   x     T2          y   node
     *  / \                   /    \
     * y  T1                 T1    T2
     */
    private Node rightRotate(Node node){
        Node x = node.left;

        // 右旋
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色翻转
     * 用于向2-3树3节点添加元素的情况
     *     42  66    42        42(R)
     *    /   ——>  / \  ——> /  \
     *   37        37 66     37(B)66(B)
     * @param node
     */
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 向红黑树中添加元素
     * @param key
     * @param value
     */
    public void add(K key, V value){
        root = add(root,key,value);
        // 将根节点设置为黑色
        root.color = BLACK;
    }

    /**
     * 向以node为根的红黑树中插入元素
     * 返回插入新节点后红黑树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node,K key, V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key)<0)
            node.left = add(node.left,key,value);
        else if(key.compareTo(node.key)>0)
            node.right = add(node.right,key,value);
        else
            node.value = value;

        // 红黑树性质维护
        // 左旋
        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);
        // 右旋
        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        // 颜色翻转
        if(isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    /**
     * 返回以node为根节点的红黑树中，key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node,K key){
        if(node == null)
            return null;
        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key)<0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);
    }

    /**
     * 红黑树中是否存在某元素
     * @param key
     * @return
     */
    public boolean contains(K key){
        return getNode(root,key)!=null;
    }

    /**
     * 获取某元素的值
     * @param key
     * @return
     */
    public V get(K key){
        Node node = getNode(root,key);
        return node == null?null:node.value;
    }

    /**
     * 设置某节点的值
     * @param key
     * @param newValue
     */
    public void set(K key,V newValue){
        Node node = getNode(root,key);
        if(node == null)
            throw new IllegalArgumentException(key+" doesn't exist!");
        node.value = newValue;
    }
}