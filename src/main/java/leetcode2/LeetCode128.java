package leetcode2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mr.黄
 * @description 最长连续序列
 * @since 2024/6/5 23:52
 **/
public class LeetCode128 {
    // [100,4,200,1,3,2]
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
