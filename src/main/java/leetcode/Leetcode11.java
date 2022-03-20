package leetcode;

/**
 * 盛最多水的容器
 *
 * @author Mr.黄
 * @date 2022/03/19
 **/
public class Leetcode11 {
    /**
     * 利用双指针解题
     *
     * @param height 给定的数组
     * @return 返回最大的容器
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, temp);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}