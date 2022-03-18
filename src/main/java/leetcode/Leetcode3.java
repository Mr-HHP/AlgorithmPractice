package leetcode;

/**
 * 无重复字符的最长子串
 *
 * @author Mr.黄
 * @date 2022/03/19
 **/
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int left = -1;
        int right = 0;
        int longest = 1;
        // 标记是否出现重复字符
        int countDup = 0;
        for (; right < s.length(); right++) {
            counts[s.charAt(right)]++;
            if (counts[s.charAt(right)] == 2) {
                countDup++;
            }
            while (countDup > 0) {
                left++;
                counts[s.charAt(left)]--;
                if (counts[s.charAt(left)] == 1) {
                    countDup--;
                }
            }
            longest = Math.max(right - left, longest);
        }
        return longest;
    }
}