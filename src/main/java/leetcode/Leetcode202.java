package leetcode;

/**
 * 快乐数
 *
 * @author Mr.黄
 * @date 2022/04/09
 **/
public class Leetcode202 {
    /**
     * 利用双指针法解题
     *
     * @param n 给定的正整数
     * @return 返回是否为快乐数
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
    
    /**
     * 获取下一个数字
     *
     * @param n 正整数
     * @return n的下一个数字
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}