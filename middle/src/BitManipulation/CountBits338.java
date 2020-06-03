package BitManipulation;

import java.util.Arrays;

/*
* 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
* 示例 1:
* 输入: 2
* 输出: [0,1,1]
* */
public class CountBits338 {
    public static void main(String[] args) {
        int num = 5;
        int[] res = countBits(num);
        System.out.println(Arrays.toString(res));
    }
    //方法一：pop count
    private static int[] countBits(int num) {
        int[] temp = new int[num+1];
        for (int i = 0; i <= num; i++) {
            temp[i] = popCount(i);
        }
        return temp;
    }

    private static int popCount(int x) {
        int count;
        for (count = 0;x != 0;count++){
            x &= x - 1;//清除最不重要的非零位
        }
        return count;
    }
}
