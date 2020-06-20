package 动态规划;

/* 64.最小路径和
* 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
来源：力扣（LeetCode）
* */
public class MinPathSum64 {
    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = minPathSum(nums);
        System.out.println(res);
    }

    //方法一：暴力解法 时间复杂度 ：O(2^{m+n})每次移动最多可以有两种选择。
//空间复杂度 ：O(m+n)。递归的深度是 m+nm+n。
//    public static int minPathSum(int[][] grid){
//        return calculate(grid,0,0);
//    }
//    public static int calculate(int[][] grid,int i, int j){
//        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
//        if (i == grid.length - 1 &&  j == grid[0].length - 1) return grid[i][j];
//        return grid[i][j] + Math.min(calculate(grid,i+1,j),calculate(grid,i,j+1));
//    }
//方法二：二维动态规划 时间复杂度 ：O(mn)；空间复杂度 ：O(mn)
//    public static int minPathSum(int[][] grid){
//        int[][] dp = new int[grid.length][grid[0].length];
//        for (int i = grid.length-1; i >= 0 ; i--) {
//            for (int j = grid[0].length - 1; j >= 0 ; j--) {
//                if (i == grid.length-1 && j != grid[0].length-1 ) {
//                    dp[i][j] = grid[i][j] + dp[i][j+1];
//                }else if(i != grid.length-1 && j == grid[0].length-1){
//                    dp[i][j] = grid[i][j] + dp[i+1][j];
//                }else if(i == grid.length-1 && j == grid[0].length-1){
//                    dp[i][j] = grid[i][j];
//                }else {
//                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
//                }
//            }
//        }
//        return dp[0][0];
//    }
//    方法三：动态规划（不需要额外存储空间） 时间复杂度 ：O(mn)；空间复杂度 ：O(1)
    public static int minPathSum(int[][] grid) {

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i == grid.length - 1 && j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
}
