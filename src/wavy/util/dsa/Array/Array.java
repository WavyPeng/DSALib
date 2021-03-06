package wavy.util.dsa.Array;

/**
 * Array
 * 基于Java静态数组二次封装的动态数组类
 * Created by WavyPeng on 2018/7/1.
 */
public class Array<E> {
    /**基本数组 */
    private E[] data;
    /**元素个数 */
    private int size;

    /**
     * 默认构造器
     * 默认容量为10
     */
    public Array(){
        this(10);
    }

    /**
     * 构造器
     * @param capacity 数组容量
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 构造器
     * @param arr
     */
    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i] = arr[i];
        size = arr.length;
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向数组首部添加元素
     * @param e 添加的元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向数组末尾添加元素
     * @param e 添加的元素
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在指定位置插入元素
     * @param index 指定索引
     * @param e 待插入元素
     */
    public void add(int index, E e){
        // 判断索引是否合法
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<=size.");

        // 判断容量是否足够
        if(size == data.length)
            resize(2 * data.length);

        for(int i = size-1;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取数组中的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 获取数组末尾元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取数组首部元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 设置index处的元素
     * @param index
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 数组中是否包含某元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0;i < size;i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 数组中查找某元素e
     * 存在返回索引，不存在返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0;i < size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除索引位置的元素并返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        E ret = data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak

        // 缩容，当size==capacity/4时才触发缩容
        if(size == data.length >> 2 && data.length >> 1 != 0)
            resize(data.length >> 1);

        return ret;
    }

    /**
     * 删除数组首部元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组末尾元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除数组中的元素e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    /**
     * 交换数组中的两个元素
     * @param i
     * @param j
     */
    public void swap(int i,int j){
        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 将数组转换成字符串
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append("[");
        for(int i = 0;i < size;i++){
            res.append(data[i]);
            if(i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 动态扩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0;i < size;i++)
            newData[i] = data[i];
        data = newData;
    }
}
