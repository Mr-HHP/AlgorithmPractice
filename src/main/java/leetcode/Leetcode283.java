package leetcode;

/**
 * 移动零
 *
 * @author Mr.黄
 * @date 2022/04/20
 **/
public class Leetcode283 {
    /**
     * 双指针法解题
     *
     * @param nums 给定的数组
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}