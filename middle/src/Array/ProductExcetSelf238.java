package Array;
/* 238.除自身以外数组的乘机
* 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
示例:输入: [1,2,3,4] 输出: [24,12,8,6]
来源：力扣（LeetCode）
* */
import java.util.Arrays;

public class ProductExcetSelf238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] output = productExceptSelf(nums);
        System.out.println(Arrays.toString(output));
    }
//1.暴力算法。使用了除法。题目要求不使用除法，并且时间复杂度为O(n)，不能使用嵌套for循环
//    private static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] temp = new int[n];
//        int abs = nums[0];
//        for (int i = 1; i < n  ; i++) {
//            abs *= nums[i];
//        }
//        for (int i = 0; i < n ; i++) {
//            temp[i] = abs/nums[i];
//        }
//        return temp;
//    }
//   2.前缀之积 * 后缀之积 时间复杂度O(n),空间复杂度O(n)
//    private static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] answer = new int[n];
//        int[] L = new int[n];
//        int[] R = new int[n];
//        //计算前缀积
//        L[0] = 1;
//        for (int i = 1; i < n; i++) {
//            L[i] = L[i - 1] * nums[i - 1];
//        }
//        //计算后缀积
//        R[n - 1] = 1;
//        for (int i = n - 2; i >= 0; i--) {
//            R[i] = R[i + 1] * nums[i + 1];
//        }
//        //计算answer
//        for (int i = 0; i < n; i++) {
//            answer[i] = L[i] * R[i];
//        }
//
//        return answer;
//    }
    //   3.前缀之积 * 后缀之积（优化），使用answer暂存前缀之积，后缀之积用一个数字表示，直接
    //    乘在answer上。时间复杂度O(n),空间复杂度O(1)，answer的空间占用不计入空间复杂度
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int temp = 1;
        //计算前缀积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        //计算  前缀积 * 后缀积
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= temp;
            temp *= nums[i];
        }
        return answer;
    }
}
