package leetcode;

/**
 * 验证回文字符串
 *
 * @author Mr.黄
 * @date 2022/03/23
 **/
public class Leetcode125 {
    /**
     * 双指针法解题
     *
     * @param s 字符串
     * @return 是否是回文
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}