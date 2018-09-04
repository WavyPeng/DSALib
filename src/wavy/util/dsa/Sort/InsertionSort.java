package wavy.util.dsa.Sort;
/**
 * 插入排序O(n^2)
 * Created by WavyPeng on 2018/9/04.
 */
public class InsertionSort {
    private InsertionSort(){}

    /**
     * 插入排序
     * @param arr
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            Comparable e = arr[i];
            int j = i;
            for(;j>0 && arr[j-1].compareTo(e)>0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("wavy.util.dsa.Sort.InsertionSort", arr);
        SortTestHelper.printArray(arr);
    }
}