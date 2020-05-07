package Array;
/*
* 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现
* 一次。找到所有在 [1, n] 范围之间没有出现在数组中的数字。
* 在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内
* 来源：力扣（LeetCode）
* */
import java.util.*;


public class FindDisappearedNumbers448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers2(nums);
        System.out.println(disappearedNumbers);
    }
    // 将整型数组放入HashMap中进行判断
    // 时间复杂度O（n），空间复杂度 O（n）
    public static List<Integer> findDisappearedNumbers(int nums[]){
        if(nums == null){
            return null;
        }
        int len = nums.length;
        HashMap<Integer,Boolean> hashTable = new HashMap<>();
        for (int i = 0; i < len; i++) {
            hashTable.put(nums[i],true);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!hashTable.containsKey(i+1)){
               res.add(i+1);
            }
        }
        return res;
    }
    // 对上面的方法进行修改，在输入数组本身以某种方式标记已访问过的数字，然后再找到缺失的数字，降低空间复杂度
    // 时间复杂度O（n），空间复杂度 O（1）
    // 遍历输入数组的每个元素一次。
    //我们将把 |nums[i]|-1 索引位置的元素标记为负数。即 nums[|nums[i] |- 1] ×−1 。
    //然后遍历数组，若当前数组元素 nums[i] 为负数，说明我们在数组中存在数字 i+1。

    public static List<Integer> findDisappearedNumbers2(int nums[]){

        for (int i = 0; i < nums.length ; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0){
                nums[index] *= -1;
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] >0){
                list.add(i+1);
            }
        }
        return list;
    }
}
