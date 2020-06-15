package Array;
/* 287.寻找重复数
* 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
* 假设只有一个重复的整数，找出这个重复的数。
示例 1:输入: [1,3,4,2,2]输出: 2
示例 2:输入: [3,1,3,4,2]输出: 3
说明：不能更改原数组（假设数组是只读的）。只能使用额外的 O(1) 的空间。时间复杂度小于 O(n2) 。数组中只有一个重复的数字，但它可能不止重复出现一次。
来源：力扣（LeetCode）
*/

import java.util.Arrays;

public class FindDuplicate287 {
    public static void main(String[] args) {
        int[] nums = {7, 9, 7, 4, 2, 8, 7, 7, 1, 5};
        int res = findDuplicate(nums);
        System.out.println(res);
    }

    //1.二分法：时间复杂度：O(nlogn)；空间复杂度O(1)
//    private static int findDuplicate(int[] nums) {
//        int n = nums.length;
//        int left = 1;
//        int right = n - 1;
//        int ans = -1;
//        while (left <= right){
//            int middle = (left + right) / 2;
//            int count = 0;
//
//            for (int i = 0; i < n ; i++) {
//                if (nums[i] <= middle ){
//                    count++;
//                }
//            }
//            if (count <= middle){
//                left  = middle +1;
//            }else {
//                right = middle -1;
//                ans = middle;
//            }
//        }
//        return ans;
//    }
//    方法二：快慢指针
    private static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

}
