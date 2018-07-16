package wavy.util.dsa.Heap;

import wavy.util.dsa.Array.Array;

/**
 * 大顶堆
 * Created by WavyPeng on 2018/7/4.
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    /**
     * 默认构造器
     */
    public MaxHeap(){
        data = new Array<E>();
    }

    /**
     * 构造器
     * @param capacity 容量
     */
    public MaxHeap(int capacity){
        data = new Array<E>(capacity);
    }

    /**
     * 构造器
     * 将数组heapify
     * @param arr
     */
    public MaxHeap(E[] arr){
        data = new Array<E>(arr);
        for(int i = parent(arr.length-1);i>=0;i--)
            siftDown(i);
    }

    /**
     * 获取堆中元素个数
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    /**
     * 查看堆中最大元素
     * @return
     */
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    /**
     * 取出堆中的最大元素
     * @return
     */
    public E extractMax(){
        E ret = findMax();

        // 取出堆顶元素后要调整堆
        // 1.将末尾节点与堆顶交换
        data.swap(0,data.getSize()-1);
        // 2.移除末尾元素
        data.removeLast();
        // 3.调整堆
        siftDown(0);

        return ret;
    }

    /**
     * 替换堆中最大元素
     * @param e
     * @return
     */
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    /**
     * 节点上浮操作
     * @param k
     */
    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 节点下沉操作
     * @param k
     */
    private void siftDown(int k){
        while(leftChild(k) < data.getSize()){
            // 确定左右孩子中最大的那个
            int j = leftChild(k);
            if(j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;

            // 如果当前节点比子节点大
            if(data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k,j);
            k = j;
        }
    }

    /**
     * 返回当前节点的父节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1)/2;
    }

    /**
     * 返回当前节点左孩子的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回当前节点右孩子的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }
}