package leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.黄
 * @description 和为 K 的子数组
 * @since 2024/6/8 14:19
 **/
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        for (int num : nums) {
            sum += num;
            count = sumCount.getOrDefault(sum - k, 0) + count;
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode560 leetCode560 = new LeetCode560();
        System.out.println(leetCode560.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
