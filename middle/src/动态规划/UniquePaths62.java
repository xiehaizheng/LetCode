package 动态规划;
/*
*
* */
public class UniquePaths62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int res = uniquePath(m,n);
        System.out.println(res);
    }
// 方法一：每个位置的路径 = 该位置左边的路径 + 该位置上边的路径
//    private static int uniquePath(int m, int n) {
//        int[] res = new int[n];
//        for (int i = 0; i <n ; i++) {
//            res[i] = 1;
//        }
//        for (int i = 0; i < m-1 ; i++) {
//            for (int j = 1; j < n; j++) {
//                res[j] += res[j-1];
//            }
//        }
//        return res[n-1];
//    }
    // 方法二：排列组合 因为机器到底右下角，向下几步，向右几步都是固定的，
//比如，m=3, n=2，我们只要向下 1 步，向右 2 步就一定能到达终点。所以有 C上标{m-1}下标{m+n-2}
    private static int uniquePath(int m, int n){
        int res = factorial(m+n-2)/factorial(m-1)/factorial(n-1);
        return res;
    }
//阶乘函数
    public static int  factorial(int  number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

}
