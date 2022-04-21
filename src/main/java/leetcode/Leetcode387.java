package leetcode;

/**
 * 字符串中第一个唯一字符
 *
 * @author Mr.黄
 * @date 2022/04/21
 **/
public class Leetcode387 {
    /**
     * 使用哈希表解题
     *
     * @param s 给定的字符串
     * @return 返回结果
     */
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}