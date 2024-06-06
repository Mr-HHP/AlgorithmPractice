package leetcode2;

/**
 * @author Mr.黄
 * @description 移动零
 * @since 2024/6/6 0:20
 **/
public class LeetCode283 {
    // [0,1,0,3,12]
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
