package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author Mr.黄
 * @date 2022/03/20
 **/
public class Leetcode15 {
    /**
     * 排序 + 双指针解题
     *
     * @param nums 给定的无序数组
     * @return 返回结果集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i, result);
                // 跳过重复的数字
                int temp = nums[i];
                while (i < nums.length && nums[i] == temp) {
                    i++;
                }
            }
        }
        return result;
    }
    
    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int k = nums.length - 1;
        int j = i + 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 跳过重复的数字
                int temp = nums[j];
                while (nums[j] == temp && j < k) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}