package wavy.util.dsa;

/**
 * Array
 * 基于Java静态数组二次封装的动态数组类
 * Created by WavyPeng on 2018/7/1.
 */
public class Array {
    /**基本数组 */
    private int[] data;
    /**元素个数 */
    private int size;

    /**
     * 默认构造器
     * 默认容量为10
     */
    public Array(){
        this(10);
        size = 0;
    }

    /**
     * 构造器
     * @param capacity 数组容量
     */
    public Array(int capacity){
       data = new int[capacity];
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
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 向数组末尾添加元素
     * @param e 添加的元素
     */
    public void addLast(int e){
        add(size,e);
    }

    /**
     * 在指定位置插入元素
     * @param index 指定索引
     * @param e 待插入元素
     */
    public void add(int index, int e){
        // 判断容量是否足够
        if(size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");
        // 判断索引是否合法
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<=size.");

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
    public int get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 设置index处的元素
     * @param index
     */
    public void set(int index, int e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 数组中是否包含某元素e
     * @param e
     * @return
     */
    public boolean contains(int e){
        for(int i = 0;i < size;i++){
            if(data[i] == e)
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
    public int find(int e){
        for(int i = 0;i < size;i++){
            if(data[i] == e)
                return i;
        }
        return -1;
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
}
