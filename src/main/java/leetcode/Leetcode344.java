package leetcode;

/**
 * 反转字符串
 *
 * @author Mr.黄
 * @date 2022/04/21
 **/
public class Leetcode344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}