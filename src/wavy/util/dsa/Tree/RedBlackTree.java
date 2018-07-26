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
}