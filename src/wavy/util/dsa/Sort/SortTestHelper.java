package wavy.util.dsa.Sort;

import java.lang.reflect.Method;

/**
 * 排序测试类
 * Created by WavyPeng on 2018/9/04.
 */
public class SortTestHelper {
    private SortTestHelper(){}

    /**
     * 生成n个元素的随机数，每个元素的随机范围为[rangeL,rangeR]
     * @param n 元素个数
     * @param rangeL 范围左边界
     * @param rangeR 范围右边界
     * @return
     */
    public static Integer[] generateRandomArray(int n,int rangeL,int rangeR){
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++)
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }

    /**
     * 打印数组内容
     * @param arr
     */
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }

    /**
     * 判断arr数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr){
        for(int i=0;i<arr.length-1;i++)
            if(arr[i].compareTo(arr[i+1])>0)
                return false;
        return true;
    }

    /**
     * 测试排序算法的正确性和运行时间
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName,Comparable[] arr){
        try{
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method method = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            method.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}