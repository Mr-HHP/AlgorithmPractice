package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.黄
 * @description 轮转数组
 * @since 2024/6/15 11:35
 **/
public class LeetCode189 {
    // [1,2,3,4,5,6,7]
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int mod = k % length;
        if (mod != 0) {
            reverse(nums, 0, length - 1);
            reverse(nums, 0, mod - 1);
            reverse(nums, mod, length - 1);
        }

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
