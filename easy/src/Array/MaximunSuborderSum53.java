/*
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 实例：
 * 输入：[-2,1,-3,4,-1,2,1,-5,4],输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * */
package Array;

public class MaximunSuborderSum53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int result =  maxSubArray(nums);
        //int result =  maxSubArray2(nums);
        int result = maxSubArray3(nums);
        System.out.println(result);
    }

    // 使用贪心算法，时间复杂度为O（n）
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;//Integer.MIN_VALUE 为整型变量的最小值
        for (int num : nums) { // 如果累加到小于0了，就清零重新累加
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            res = Math.max(sum, res);
        }
        return res;
    }

    // 使用动态规划的解法，时间复杂度为O（n），代码化简之后，竟然和贪心算法一模一样
    public static int maxSubArray2(int[] nums) {
        int N = nums.length;
        int dp[] = new int[N + 1];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for (int k = 1; k <= N; k++) {
            //子问题的递推关系
            //f(0) = 0
            //f(k) = max{f(k-1)+nums[k-1],nums[k-1]}=max{f(k-1),0}+nums[k-1]
            dp[k] = Math.max(dp[k - 1], 0) + nums[k - 1];
            res = Math.max(res, dp[k]);
        }
        return res;
    }

    //分治算法(看不明白)，时间复杂度O（NlogN）
    public static int maxSubArray3(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    private static int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;

        return max3(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right));
    }

    private static int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

}
