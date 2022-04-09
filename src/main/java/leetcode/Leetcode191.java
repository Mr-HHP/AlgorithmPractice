package leetcode;

/**
 * 位1的个数
 *
 * @author Mr.黄
 * @date 2022/04/09
 **/
public class Leetcode191 {
    /**
     * 利用 i & (i - 1)解题
     * @param n 给定二进制整数
     * @return 返回结果
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}