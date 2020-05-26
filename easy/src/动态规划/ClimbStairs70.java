package 动态规划;
/*
*  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
*  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
*  注意：给定 n 是一个正整数。
*  符合：斐波那契数
*  不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，
*  我们可以使用动态规划来解决这一问题。第 ii 阶可以由以下两种方法得到：1.在第 (i-1)(i−1) 阶后向上爬一阶。
*  2.在第 (i-2)(i−2) 阶后向上爬 22 阶。
* */
public class ClimbStairs70 {
    public static void main(String[] args) {
        int n = 5;
        int res = climbStairs(n);
        System.out.println(res);
    }
    //1.动态规划，时间复杂度：O(n)，空间复杂度 ：O(n)。
//    public static int climbStairs(int n){
//        if (n == 1) return 1;
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n ; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }
    //2.：斐波那契数，时间复杂度：O(n)，空间复杂度 ：O(1)。
    public static int climbStairs(int n){
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n ; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
