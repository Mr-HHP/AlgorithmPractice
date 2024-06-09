package leetcode2;

/**
 * @author Mr.黄
 * @description 最大子数组和
 * @since 2024/6/9 15:17
 **/
public class LeetCode53 {
    // [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int result = nums[0];
        for (int num : nums) {
            if (pre + num > num) {
                pre += num;
            } else {
                pre = num;
            }
            result = Math.max(pre, result);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        leetCode53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
