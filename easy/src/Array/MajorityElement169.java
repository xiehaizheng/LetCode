package Array;
/*
* 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
* 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/majority-element
* */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int res = majorityElement2(nums);
        System.out.println(res);
    }
    // 1.HashMap 时间复杂度：O(n)
    // 我们用一个循环遍历数组 nums 并将数组中的每个元素加入哈希映射中。在这之后，我们遍历哈希映射中的
    // 所有键值对，返回值最大的键。我们同样也可以在遍历数组 nums 时候使用打擂台的方法，维护最大的值，
    // 这样省去了最后对哈希映射的遍历。
    public static int majorityElement(int[] nums){
        // 循环遍历数组，找出最大值
        Map<Integer,Integer> counts = countMums(nums);
        Map.Entry<Integer,Integer> majorityEntry = null;
        for (Map.Entry<Integer,Integer> entry:counts.entrySet()
             ) {
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    public static Map<Integer,Integer> countMums(int[] nums){
        //循环遍历数组 nums 并将数组中的每个元素及其个数加入哈希映射中
        Map<Integer,Integer> counts = new HashMap<>();
        for (int num: nums) {
            if (!counts.containsKey(num)){
                counts.put(num,1);
            }else {
                counts.put(num,counts.get(num)+1);
            }
        }
        return counts;
    }
    // 2. 排序
    // 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为
    // N/2 元素一定是众数
    public static int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
