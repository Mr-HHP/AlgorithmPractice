package leetcode;

/**
 * 跳跃游戏
 *
 * @author Mr.黄
 * @date 2022/04/03
 **/
public class Leetcode55 {
    /**
     * 贪心法解题
     *
     * @param nums 给定的非负整数数组
     * @return 返回结果
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}