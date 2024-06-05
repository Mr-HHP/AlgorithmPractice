package leetcode2;

import java.util.*;

/**
 * @author Mr.黄
 * @description LeetCode49
 * @since 2024/6/5 0:38
 **/
public class LeetCode49 {
    // ["eat","tea","tan","ate","nat","bat"]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
