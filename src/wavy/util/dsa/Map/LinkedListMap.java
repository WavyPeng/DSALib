package wavy.util.dsa.Map;
/**
 * 映射实现
 * 基于链表实现
 * Created by WavyPeng on 2018/7/16.
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value){
            this(key,value,null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }
    }

    /**辅助头节点 */
    private Node dummyHead;
    /**大小 */
    private int size;

    /**
     * 构造器
     */
    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取某节点
     * @param key
     * @return
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        // 节点不重复
        if (node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else { // 节点重复
            node.value = value;
        }
    }

    /**
     * 删除元素
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        // 1.查询待删除元素
        while (prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }
        // 2.删除元素
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
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
        return getNode(key) != null;
    }

    /**
     * 获取元素
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 设置元素
     * @param key
     * @param newVal
     */
    @Override
    public void set(K key, V newVal) {
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newVal;
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