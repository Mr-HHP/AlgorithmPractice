package leetcode;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author Mr.黄
 * @date 2022/03/26
 **/
public class Leetcode49 {
    /**
     * 利用排序解题
     *
     * @param strs 给定的字符串数组
     * @return 结果
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}