package wavy.util.dsa.HashTable;

import java.util.TreeMap;

/**
 * 哈希表
 * Created by WavyPeng on 2018/7/10.
 */
public class HashTable<K, V> {

    /**容量素数表 */
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    /**冲突时节点的组织结构TreeMap，底层基于红黑树 */
    private TreeMap<K, V>[] hashtable;
    /**TreeMap数组大小*/
    private int M;
    /**哈希表大小*/
    private int size;

    /**平均每个地址允许哈希冲突的上界 */
    private static final int upperTol = 10;
    /**平均每个地址允许哈希冲突的下界 */
    private static final int lowerTol = 2;
    /**容量表索引 */
    private int capacityIndex = 0;

    /**
     * 构造器
     * @param M
     */
    public HashTable(int M){
        this.M = capacity[capacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0 ; i < M ; i ++)
            hashtable[i] = new TreeMap<>();
    }

    /**
     * 将传入的key转换为数组中对应的索引
     * @param key
     * @return
     */
    private int hash(K key){
        // &0x7fffffff去除符号位
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 哈希表大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 添加节点
     * @param key
     * @param value
     */
    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key))
            map.put(key, value);
        else{
            map.put(key, value);
            size ++;

            if(size >= upperTol * M && capacityIndex + 1 < capacity.length){
                capacityIndex ++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    /**
     * 删除节点
     * @param key
     * @return
     */
    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;

            if(size < lowerTol * M && capacityIndex - 1 >= 0){
                capacityIndex --;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    /**
     * 设置哈希表的值
     * @param key
     * @param value
     */
    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    /**
     * 判断是否包含某个key
     * @param key
     * @return
     */
    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    /**
     * 获取key对应的value
     * @param key
     * @return
     */
    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    /**
     * 扩容
     * @param newM
     */
    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0 ; i < newM ; i ++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;
        // 注意此处要进行处理，更新成扩容后的值
        // 为了使后面散列新哈希表求哈希值时计算不出错
        this.M = newM;
        for(int i = 0 ; i < oldM ; i ++){
            TreeMap<K, V> map = hashtable[i];
            for(K key: map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        this.hashtable = newHashTable;
    }
}
