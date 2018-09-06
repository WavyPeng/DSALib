package wavy.applications.Tree.RangeSumQuery;

import wavy.util.dsa.Tree.SegmentTree;

/**
 * 307. Range Sum Query - Mutable
 *
 * Given an integer array nums,
 * find the sum of the elements between
 * indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * 直接数组内更新会造成超时，这里采用线段树来解决
 *
 * Created by WavyPeng on 2018/09/06.
 */
public class NumArray3 {

    private SegmentTree<Integer> segmentTree;

    public NumArray3(int[] nums) {
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for(int i=0;i<nums.length;i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data,(a,b)->a+b);
        }
    }

    public void update(int index, int val) {
        if(segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null");

        segmentTree.set(index,val);
    }

    public int sumRange(int i, int j) {
        if(segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null");
        return segmentTree.query(i,j);
    }
}