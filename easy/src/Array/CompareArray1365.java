package Array;

import java.util.Arrays;

/*
* 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
*换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
*以数组形式返回答案。
* */
public class CompareArray1365 {
    public static void main(String[] args) {
        int[] num1 = {7,7,7,7};
        int[] out = compare(num1);
        System.out.println(Arrays.toString(out));
    }
    public  static int[]  compare(int[] a){
        int[] num2 = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            int count = 0;
            for (int j = 0; j <a.length ; j++) {
                if(a[i]>a[j]){
                    ++count;
                }
            }
            num2[i]= count;
        }
        return num2;
    }
}
