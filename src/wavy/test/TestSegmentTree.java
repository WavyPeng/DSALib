package wavy.test;

import wavy.util.dsa.Tree.Merger;
import wavy.util.dsa.Tree.SegmentTree;

public class TestSegmentTree {
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
         // 写法一：
//        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
//            @Override
//            public Integer merge(Integer a, Integer b) {
//                return a + b;
//            }
//        });
        // 写法二：
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,(a,b)->a+b);
        System.out.println(segTree);
    }
}