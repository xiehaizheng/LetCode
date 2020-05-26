package 动态规划;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互
 * 连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 首先看 n = 1 的情况，显然 f(1) = A1
 * ​*   再看 n = 2，f(2) = max(A1, A2)。
 * 对于 n = 3，有两个选项:
 * 抢第三个房子，将数额与第一个房子相加。
 * 不抢第三个房子，保持现有最大数额。
 * 显然，你想选择数额更大的选项。于是，可以总结出公式：
 * f(k) = max(f(k – 2) + Ak, f(k – 1))
 * 来源：力扣（LeetCode）
 */

public class Rob198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }
//    时间复杂度：O(n)。空间复杂度：O(1)。
    public static int rob(int[] num){
        int prevMax = 0;
        int currMax = 0;
        for (int i : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + i , currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
