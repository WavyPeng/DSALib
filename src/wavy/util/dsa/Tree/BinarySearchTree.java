package wavy.util.dsa.Tree;

import wavy.util.dsa.Queue.LoopQueue;
import wavy.util.dsa.Stack.ArrayStack;

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

    /**
     * 查看元素是否存在
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }

    /**
     * 前序遍历（递归实现）
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后续遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 前序遍历（非递归实现）
     */
    public void preOrderNR(){
        if(root == null)
            return;

        ArrayStack<Node> stack = new ArrayStack<>();
        // 1.将根节点压栈
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        if(root == null)
            return;

        LoopQueue<Node> queue = new LoopQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()){
            Node cur = queue.dequeue();
            System.out.println(cur.e);
            if(cur.left != null)
                queue.enqueue(cur.left);
            if(cur.right != null)
                queue.enqueue(cur.right);
        }
    }

    /**
     * 寻找最小元素
     * @return
     */
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node minNode = minimum(root);
        return minNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if( node.left == null )
            return node;

        return minimum(node.left);
    }

    /**
     * 寻找最大元素
     * @return
     */
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node maxNode = maximum(root);
        return maxNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
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
            node.right = null; // 将当前节点从二叉树中脱离
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点, 返回最大值
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 删除二分搜索树指定节点
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 基于Hibbard Deletion算法
     * 删除掉以node为根的二分搜索树中值为e的节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0){  // 目标比当前节点小，向左找
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){ // 目标比当前节点大，向右找
            node.right = remove(node.right,e);
            return node;
        }else { // 找到目标节点
            // 1.待删除节点左子树为空的情况，同删除最小值情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 2.待删除节点右子树为空的情况，同删除最大值情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 3.待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null; // 将目标节点删去
            return successor;
        }
    }

    /**
     * 将二叉搜索树转换成字符串格式输出
     * 按前序遍历格式输出
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<depth;i++)
            res.append("--");
        return res.toString();
    }

}
