package wavy.util.dsa.Tree;

/**
 * 线段树
 * Created by WavyPeng on 2018/09/05.
 */
public class SegmentTree<E> {
    /**存储线段树 */
    private E[] tree;
    /**存储区间元素 */
    private E[] data;
    /**融合器 */
    private Merger<E> merger;

    /**
     * 构造器
     * @param arr
     * @param merger 融合器
     */
    public SegmentTree(E[] arr, Merger<E> merger) {
        // 初始化融合器
        this.merger = merger;

        data = (E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i] = arr[i];
        tree = (E[])new Object[4*arr.length];
        // 构建线段树
        buildSegmentTree(0,0,data.length-1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     * @param treeIndex 线段树根节点对应的索引
     * @param l 区间左端点
     * @param r 区间右端点
     */
    private void buildSegmentTree(int treeIndex,int l,int r){
        // 叶节点
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        // 每个节点的值受业务逻辑影响（求和？最大值？最小值？）
        // 这里采用融合器来实现
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }


    /**
     * 返回区间[queryL,queryR]的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryR >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0,0,data.length-1,queryL,queryR);
    }

    /**
     * 在以treeIndex为根的线段树中[l...r]的范围内，搜索区间[queryL,queryR]的值
     * @param treeIndex 线段树根的index
     * @param l         线段树左范围
     * @param r         线段树右范围
     * @param queryL    搜索区间左范围
     * @param queryR    搜索区间右范围
     * @return
     */
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l == queryL && r == queryR)
            return tree[treeIndex];
        int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if(queryL >= mid + 1)
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        else if(queryR <= mid)
            return query(leftTreeIndex,l,mid,queryL,queryR);

        E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
        E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);

        return merger.merge(leftResult,rightResult);
    }



    /**
     * 获取元素个数
     * @return
     */
    public int getSize(){
        return data.length;
    }

    /**
     * 获取某个元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    /**
     * 返回完全二叉树数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return 2*index+1;
    }

    /**
     * 返回完全二叉树数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return 2*index+2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i=0;i<tree.length;i++){
            if(tree[i]!=null)
                res.append(tree[i]);
            else
                res.append("null");
            if(i!=tree.length-1)
                res.append(", ");
        }
        return res.toString();
    }
}