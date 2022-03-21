package leetcode;

/**
 * 加一
 *
 * @author Mr.黄
 * @date 2022/03/22
 **/
public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
            
        }
        //如果所有位都是进位，则长度+1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}