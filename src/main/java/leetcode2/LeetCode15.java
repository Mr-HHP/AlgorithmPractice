package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.黄
 * @description 三数之和
 * @since 2024/6/7 0:56
 **/
public class LeetCode15 {
    // [-1,0,1,2,-1,-4]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 有序后用双指针法
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int temp = nums[left];
                    while (nums[left] == temp && left < right) {
                        left++;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }
            }
        }
        return result;
    }
}
