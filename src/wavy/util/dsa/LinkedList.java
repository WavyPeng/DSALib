package wavy.util.dsa;
/**
 * 链表
 * Created by WavyPeng on 2018/7/10.
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    /**链表的虚拟头节点 */
    private Node dummyHead;
    /**链表大小 */
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        // 1.Node node = new Node(e);
        // 2.node.next = prev.next;
        // 3.prev.next = node;
        // 1~3插入节点的简单写法
        prev.next = new Node(e,prev.next);
        size++;
    }

    /**
     * 首部插入
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 尾部插入
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获得链表的第index(0-based)个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node cur = dummyHead.next;
        for(int i = 0;i < index;i++)
            cur = cur.next;
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 更新链表的第index(0-based)个位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node cur = dummyHead.next;
        for(int i = 0;i < index;i++)
            cur = cur.next;
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur!=null){
            if(e.equals(cur.e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index(0-based)位置的元素, 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        Node prev = dummyHead;
        for(int i = 0;i < index;i++)
            prev = prev.next;

        Node ret = prev.next; // 待删除节点
        prev.next = ret.next;
        ret.next = null;
        size--;
        return ret.e;
    }

    /**
     * 从链表中删除第一个元素, 返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素, 返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     * @param e
     */
    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next != null){
            if(e.equals(prev.next.e))
                break;
            prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    /**
     * 将链表转换成字符串格式输出
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}