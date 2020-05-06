package Array;
/*
* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
* 示例:
 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
* 说明:
 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 来源：力扣（LeetCode）
* */

import java.util.Arrays;

public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeroes2(nums)));

    }

    //    public static int[] moveZeroes(int[] nums){
//        int[] res = nums;
//        int[] temp = new int[res.length];
//
//        int right = res.length - 1;
//        int left = 0;
//        for (int i = 0; i <res.length ; i++) {
//            if (res[i] == 0){
//                temp[right] = res[i];
//                right--;
//            }else  {
//                temp[left] = res[i];
//                left++;
//            }
//        }
//        return temp;
//    }
    // 两次遍历
    // 创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。即遍历的时候每遇到一个非0元素就将其
    // 往数组左边挪，第一次遍历完后，j指针的下标就指向了最后一个非0元素下标。
    //第二次遍历的时候，起始位置就从j开始到结束，将剩下的这段区域内的元素全部置为0。
    public static int[] moveZeroes(int[] nums) {
        if (nums == null) {
            return null;
        }
        // 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统赋值给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
             nums[j++] = nums[i];
            }
        }
        // 非0元素统计完了，剩下的都是0了
        // 所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length ; i++) {
            nums[i] = 0;
        }
        return nums;
    }
    // 一次遍历
    public static int[] moveZeroes2(int[] nums){
        if (nums == null){
            return null;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return nums;
    }
}
