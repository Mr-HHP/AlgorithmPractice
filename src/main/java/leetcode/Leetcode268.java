package leetcode;

/**
 * 丢失的数字
 *
 * @author Mr.黄
 * @date 2022/04/19
 **/
public class Leetcode268 {
    /**
     * 作差法解题
     *
     * @param nums 给定的数组
     * @return 丢失的数字
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int cur = 0;
        for (int i : nums) {
            cur += i;
        }
        return sum - cur;
    }
}