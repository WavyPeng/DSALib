package wavy.test;

import wavy.util.dsa.BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * 二叉搜索树测试类
 * Created by WavyPeng on 2018/7/6.
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // 测试删除二分搜索树中的最小值
        Random random = new Random();

        int n = 1000;

        // test removeMin
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMin());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");


        // test removeMax
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");

//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for(int num: nums)
//            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bst.levelOrder();

//        bst.preOrder();
//        System.out.println();
//
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();
//
//        System.out.println(bst);
    }
}
