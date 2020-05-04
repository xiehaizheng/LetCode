package Array;

import java.util.Arrays;

/*
* 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
*换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
*以数组形式返回答案。
* 提示：

 2 <= nums.length <= 500
 0 <= nums[i] <= 100
通过次数12,834提交次数15,
=========================使用计数排序=========================
* */
public class CompareArray1365Better {
    public static void main(String[] args) {
        int[] num = {7,5,4,2};
        int[] out = compare(num);
        System.out.println(Arrays.toString(out));
    }
    public  static int[]  compare(int[] nums){
        // 统计出现频率 frequency
       int[] fre = new int[101];
        for (int num:nums) {
            fre[num]++;
        }
        // 对频率(而非对原数组nums)从前到后累加
        for (int i = 1; i <fre.length ; i++) {
            fre[i] = fre[i] + fre[i-1];
        }
        // 输出结果
        int result[] = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>0){
                result[i] = fre[nums[i]-1];}
        }
        return result;
    }

}
