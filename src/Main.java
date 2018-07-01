import wavy.util.dsa.Array;

/**
 * Main
 * Created by WavyPeng on 2018/7/1.
 */
public class Main {
    public static void main(String[] args) {
        // 测试Array
        Array arr = new Array(20);

        for(int i=0;i<10;i++){
           arr.addLast(i);
        }
        System.out.println(arr.toString());

        arr.add(1,100);
        System.out.println(arr.toString());

        arr.addFirst(-1);
        System.out.println(arr.toString());
    }
}
