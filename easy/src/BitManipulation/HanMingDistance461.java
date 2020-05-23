package BitManipulation;
/*
* 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。给出两个整数 x 和 y，计算它们之间的汉明距离。
* 注意：
0 ≤ x, y < 2^31
* 计算 x 和 y 之间的汉明距离，可以先计算 x XOR(异或) y，然后统计结果中等于 1 的位数。原始问题转换为位计数问题
* 方法一：内置位计数功能； 方法二：移位；方法三：布赖恩·克尼根算法
* */
public class HanMingDistance461 {
    public static void main(String[] args) {
        int x = 1 ,y = 4;
        // 方法一：内置位计数功能
//        int hanmingDistance1 = hanmingDistance1(x, y);
//        System.out.println(hanmingDistance1);
        // 方法二：移位；
//        int hanmingDistance2 = hanmingDistance2(x, y);
//        System.out.println(hanmingDistance2);
        // 法三：布赖恩·克尼根算法
        int hanmingDistance3 = hanmingDistance3(x, y);
        System.out.println(hanmingDistance3);

    }
    // 方法一：内置位计数功能 时间复杂度：O(1),空间复杂度：O(1)。
//    public static int hanmingDistance1(int x,int y){
//         return Integer.bitCount(x ^ y);
//    }
//    // 方法二：移位； 时间复杂度：O(1),空间复杂度：O(1)。
//    public static int hanmingDistance2(int x,int y){
//        int xor = x ^ y;
//        int distance = 0;
//        while(xor != 0 ){
//            if (xor%2 == 1){
//                distance += 1;
//            }
//            xor = xor >> 1 ;
//        }
//        return distance;
//    }
    // 法三：布赖恩·克尼根算法  时间复杂度：O(1),空间复杂度：O(1)。
    public static int hanmingDistance3(int x,int y){
        int xor = x ^ y;
        int distance = 0;
        while(xor != 0){
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
