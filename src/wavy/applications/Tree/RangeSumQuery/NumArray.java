package wavy.applications.Tree.RangeSumQuery;

import wavy.util.dsa.Tree.SegmentTree;

/**
 * 关于线段树的应用
 *
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Created by WavyPeng on 2018/09/06.
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for(int i=0;i<nums.length;i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data,(a,b)->a+b);
        }
    }

    public int sumRange(int i, int j) {
        if(segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null");
        return segmentTree.query(i,j);
    }
}