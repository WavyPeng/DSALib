package wavy.util.dsa;

import java.util.TreeMap;

/**
 * 哈希表
 * Created by WavyPeng on 2018/7/10.
 */
public class HashTable<K, V> {
    /**冲突时节点的组织结构TreeMap，底层基于红黑树 */
    private TreeMap<K, V>[] hashtable;
    /**TreeMap数组大小*/
    private int M;
    /**哈希表大小*/
    private int size;

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    /**
     * 构造器
     * @param M
     */
    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0 ; i < M ; i ++)
            hashtable[i] = new TreeMap<>();
    }

    /**
     * 默认构造器
     */
    public HashTable(){
        this(initCapacity);
    }

    /**
     * 哈希码
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
}
