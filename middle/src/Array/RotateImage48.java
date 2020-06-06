package Array;
/* 48.旋转图像
*  给定一个 n x n 的二维矩阵表示一个图像。将图像顺时针旋转90度。
*  tip：在原地旋转图像
*  来源：Leetcode
* */
public class RotateImage48 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int num = 1;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
        //旋转图像
        rotate(matrix);
        //打印
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
//方法一： 转置加翻转，先转置矩阵，然后翻转每一行。时间复杂度时间复杂度：O(N^2)，空间复杂度：O(1)由于旋转操作是 就地 完成的。
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        //转置矩阵 就是将matrix[j][i] 与 matrix[i][j]对调
        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //翻转每一行
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n/2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }
}
