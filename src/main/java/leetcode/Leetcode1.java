package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author Mr.黄
 * @date 2022/03/18
 **/
public class Leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>(16);
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}