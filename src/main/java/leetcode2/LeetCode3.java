package leetcode2;

import java.util.*;

/**
 * @author Mr.黄
 * @description 无重复字符的最长子串
 * @since 2024/6/8 12:33
 **/
public class LeetCode3 {
    // pwwkew
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int[] count = new int[256];
        int result = 0;
        while (left < s.length() && right < s.length()) {
            while (count[s.charAt(right)] > 0) {
                count[s.charAt(left)]--;
                left++;
            }
            count[s.charAt(right)]++;
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("abcabcbb"));
    }
}
