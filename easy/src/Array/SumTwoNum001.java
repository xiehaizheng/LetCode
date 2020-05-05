package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 给定一个整数数组 nums 和一个目标值 target，在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
*
* */
public class SumTwoNum001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum2(nums,target);
        System.out.println(Arrays.toString(result));
    }
    // 暴力方法，时间复杂度O（n^2）
    public static int[] twoSum(int[] nums,int target){
        int[] res = new int[2];
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
    // 改进 哈希表 时间复杂度O（n）
    // 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
    // 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
    // 如果最终都没有结果则抛出异常
    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum soluition");
    }
}
