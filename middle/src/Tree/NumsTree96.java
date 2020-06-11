package Tree;

/* 96.不同的二叉搜索树
*   给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
示例:输入: 3  输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
二叉搜索树（BST）/二叉排序树：对于任何一个非叶子节点，要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大
* */
public class NumsTree96 {
    public static void main(String[] args) {
        int res = numTree(3);
        System.out.println(res);
    }

    //    动态规划的方法
//    public static int numTree(int n) {
//        int[] G = new int[n + 1];
//        G[0] = 1;
//        G[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                G[i] += G[j - 1] * G[i - j];
//            }
//        }
//        return G[n];
//    }
    //    数学演绎法：事实上 G(n)函数的值被称为 卡塔兰数
    // 卡塔兰数更便于计算的定义如下:
    // C_0 = 1, C_{n+1} = {2(2n+1)}/{n+2}  * C_n
    public static int numTree(int n){
        // Note: we should use long here instead of int, otherwise overflow
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i +1)/(i + 2);
        }
        return (int) c;
    }
}
