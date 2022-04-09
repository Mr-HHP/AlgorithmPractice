package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author Mr.黄
 * @date 2022/04/09
 **/
public class Leetcode217 {
    /**
     * 利用HashMap解题
     *
     * @param nums 给定的数组
     * @return 返回结果
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            Integer count = map.getOrDefault(nums[i], 0);
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 利用Set解题
     *
     * @param nums 给定的数组
     * @return 返回结果
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Leetcode217 leetcode217 = new Leetcode217();
        System.out.println(leetcode217.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}