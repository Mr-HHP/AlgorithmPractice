package leetcode;

/**
 * 爬楼梯
 *
 * @author Mr.黄
 * @date 2022/03/22
 **/
public class Leetcode70 {
    /**
     * f(n) = f(n-1) + f(n-2)（斐波那契数列）
     * 动态规划解题
     *
     * @param n 台阶数量
     * @return 方法数量
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}