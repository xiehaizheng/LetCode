package Array;

/*
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器
 * 可以容纳最多的水。
 * 来源：力扣（LeetCode）
 */
public class MaxArea11 {
    public static void main(String[] args) {
        int[] nums = {2,3,10,5,7,8,9};
        int res = maxArea(nums);
        System.out.println(res);
    }

    private static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int area = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area,temp);
            if (height[left] <= height[right] ) {
                left += 1;

            } else  {
                right -= 1;
            }
        }
        return area;
    }
}
