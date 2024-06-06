package leetcode2;

/**
 * @author Mr.黄
 * @description 盛最多水的容器
 * @since 2024/6/6 1:06
 **/
public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(temp, result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
