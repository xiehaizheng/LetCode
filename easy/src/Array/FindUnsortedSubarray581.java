package Array;

import java.util.Arrays;

/*
* 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
* 你找到的子数组应是最短的，请输出它的长度。
* 说明 :
* 输入的数组长度范围在 [1, 10,000]。
* 输入的数组可能包含重复元素 ，所以升序的意思是<=。
* */
public class FindUnsortedSubarray581 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6,  8, 9,10, 15};
//        1.暴力算法
//        int res = findUnsortedSubarray(nums);
//        2.排序
        int res = findUnsortedSubarray2(nums);
        System.out.println(res);
    }
    // 暴力算法 时间复杂度：O(n^2)
    // 空间复杂度：O(1) 。只使用了常数空间
    public static int findUnsortedSubarray(int[] nums){

        int light = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[i]){
                    light = Math.min(light,i);
                    right = Math.max(right,j);
                }
            }
        }
        // 加入就是升序，right - light < 0
        return right - light < 0 ? 0: right - light + 1;
    }
    // 2.排序 时间复杂度：O(nlog n) 排序消耗 nlogn 的时间。
    // 空间复杂度：O(n) 。我们拷贝了一份原数组来进行排序。
    public static int findUnsortedSubarray2(int[] nums){
        int[] numsCopy = nums.clone();
        int right = 0;
        int light = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (numsCopy[i] != nums[i]){
                light = Math.min(light,i);
                right = Math.max(right,i);
            }
        }
        return right - light < 0 ? 0 : right - light +1;
    }
}
