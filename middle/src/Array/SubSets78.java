package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 相关标签： 位运算、数组、回溯算法
*  给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
*  说明：解集不能包含重复的子集。
*  示例:
*  输入: nums = [1,2,3]
*  输出:[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
* 来源：力扣（LeetCode）
* */
public class SubSets78 {
//    static int i = 0;
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subSets(nums);
        System.out.println(res);
    }
    //方法一：递归
    public static List<List<Integer>> subSets(int[] nums){
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}
