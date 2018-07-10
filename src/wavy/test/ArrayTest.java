package wavy.test;

import wavy.util.dsa.Array;
/**
 * Array测试类
 * Created by WavyPeng on 2018/7/1.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();

        for(int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr.toString());

        arr.add(1,100);
        System.out.println(arr.toString());

        arr.addFirst(-1);
        System.out.println(arr.toString());

        arr.remove(2);
        System.out.println(arr.toString());

        arr.removeElement(4);
        System.out.println(arr.toString());

        arr.removeFirst();
        System.out.println(arr.toString());

        arr.removeLast();
        System.out.println(arr.toString());
    }
}
