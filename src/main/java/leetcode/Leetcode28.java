package leetcode;

/**
 * 实现strStr()
 *
 * @author Mr.黄
 * @date 2022/03/21
 **/
public class Leetcode28 {
    /**
     * 常规暴力解法
     *
     * @param haystack 字符串haystack
     * @param needle   字符串needle
     * @return 结果下标
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}