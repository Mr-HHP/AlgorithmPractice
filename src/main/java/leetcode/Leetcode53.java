package leetcode;

/**
 * 最大子数组和
 *
 * @author Mr.黄
 * @date 2022/03/21
 **/
public class Leetcode53 {
    /**
     * 利用动态规划解题
     * 例：[-2,1,-3,4,-1,2,1,-5,4]
     *
     * @param nums 给定的整数数组
     * @return 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}