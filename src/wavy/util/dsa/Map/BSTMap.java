package wavy.util.dsa.Map;

/**
 * 映射实现
 * 基于二分搜索树实现
 * Created by WavyPeng on 2018/7/16.
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    /**
     * 节点定义
     */
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**树的根节点 */
    private Node root;
    /**大小 */
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    /**
     * 根据Key获取某节点
     * 返回以node为根节点的二分搜索树中，key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key){
        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向以node为根的二分搜索树中插入元素(key, value)，递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value){
        if(node == null){
            size++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key)<0)
            node.left = add(node.left,key,value);
        else if(key.compareTo(node.key)>0)
            node.right = add(node.right,key,value);
        else
            node.value = value;

        return node;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除节点
     * 分为三种情况：
     * ①待删除节点左子树为空
     * ②待删除节点右子树为空
     * ③待删除节点左右子树均不为空
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key){
        if(node == null)
            return null;
        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }else if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }else{
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用此节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            // 删除node
            node.left = node.right = null;

            return successor;
        }
    }

    /**
     * 删除元素
     * @param key
     * @return 待删除节点的值
     */
    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    /**
     * 判断元素是否存在
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    /**
     * 获取元素
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * 设置元素
     * @param key
     * @param newValue
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }

    /**
     * 获取大小
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
        return size == 0;
    }
}