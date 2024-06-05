package leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.黄
 * @description LeetCode
 * @since 2024/6/5 0:19
 **/
public class LeetCode1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
