package wavy.util.dsa;

/**
 * ArrayStack
 * 基于Array动态数组实现的栈
 * @param <E>
 * Created by WavyPeng on 2018/7/2.
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    /**
     * 构造器
     * @param capacity 栈容量
     */
    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    /**
     * 默认构造器
     */
    public ArrayStack() {
        array = new Array<E>();
    }

    /**
     * 获取栈容量
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 将栈转换成字符输出
     * @return
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Stack: ");
        ret.append("[");
        for(int i=0;i<array.getSize();i++){
            ret.append(array.get(i));
            if(i!=array.getSize()-1)
                ret.append(", ");
        }
        ret.append("] top");
        return ret.toString();
    }
}