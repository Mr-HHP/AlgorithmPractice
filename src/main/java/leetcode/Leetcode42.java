package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 *
 * @author Mr.黄
 * @date 2022/04/11
 **/
public class Leetcode42 {
    /**
     * 利用单调栈解题
     *
     * @param height 给定得非负整数数组
     * @return 返回结果
     */
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currentWidth = i - left - 1;
                int currentHeight = Math.min(height[left], height[i]) - height[top];
                ans += currentWidth * currentHeight;
            }
            stack.push(i);
        }
        return ans;
    }
    
    /**
     * 利用双指针法解题
     *
     * @param height 给定的非负整数数组
     * @return 返回结果
     */
    public int trap2(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}