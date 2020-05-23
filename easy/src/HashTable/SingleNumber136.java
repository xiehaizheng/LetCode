package HashTable;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 解法：
 * 1.使用集合存储数字。遍历数组中的每个数字，如果集合中没有该数字，则将该数字加入集合，如果集合中已经有该数字，则将
 *   该数字从集合中删除，最后剩下的数字就是只出现一次的数字。
 * 2.使用哈希表存储每个数字和该数字出现的次数。遍历数组即可得到每个数字出现的次数，并更新哈希表，最后遍历哈希表，得到
 *  只出现一次的数字。
 * 3.使用集合存储数组中出现的所有数字，并计算数组中的元素之和。由于集合保证元素无重复，因此计算集合中的所有元素之和的
 * 两倍，即为每个元素出现两次的情况下的元素之和。由于数组中只有一个元素出现一次，其余元素都出现两次，因此用集合中的元
 *  素之和的两倍减去数组中的元素之和，剩下的数就是数组中只出现一次的数字。
 * 4. 位运算
 * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
 * 任何数和其自身做异或运算，结果是 0，即a⊕a=0。
 * 异或运算满足交换律和结合律，即 ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
 * 作者：LeetCode-Solution
 * 来源：力扣（LeetCode）
 */

public class SingleNumber136 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,5,5,6,7,3,7};
        int singleNumber = singleNumber(nums);
        System.out.println("只出现一次的元素为：" + singleNumber);
    }
//    位运算
    public static int singleNumber(int[] nums){
        int singlenum = 0;
        for (int num : nums) {
            singlenum ^= num;
        }
        return singlenum;
    }
//
}
