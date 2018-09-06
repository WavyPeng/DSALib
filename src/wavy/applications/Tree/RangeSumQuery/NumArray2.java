package wavy.applications.Tree.RangeSumQuery;

/**
 * 303. Range Sum Query - Immutable
 *
 * 由于元素不变，因此可直接用数组解决
 *
 * Created by WavyPeng on 2018/09/06.
 */
public class NumArray2 {
    // sum[i]存储前i个元素nums[0...i-1]的和，sum[0]=0
    private int[] sum;

    public NumArray2(int[] nums){
        sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=1;i<sum.length;i++)
            sum[i] = sum[i-1]+nums[i-1];
    }

    public int sumRange(int i,int j){
        return sum[j+1]-sum[i];
    }
}