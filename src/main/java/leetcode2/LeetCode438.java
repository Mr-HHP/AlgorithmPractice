package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.黄
 * @description 找到字符串中所有字母异位词
 * @since 2024/6/8 13:52
 **/
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] counts = new int[26];
        if (s.length() < p.length()) {
            return result;
        }
        int i = 0;
        for (; i < p.length(); i++) {
            counts[p.charAt(i) - 'a']++;
            counts[s.charAt(i) - 'a']--;
        }
        if (check(counts)) {
            result.add(0);
        }

        for (; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']--;
            counts[s.charAt(i - p.length()) - 'a']++;
            if (check(counts)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public boolean check(int[] counts) {
        for (int c : counts) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
