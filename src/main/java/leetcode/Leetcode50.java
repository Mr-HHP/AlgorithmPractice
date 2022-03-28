package leetcode;

/**
 * Pow(x,n)
 *
 * @author Mr.黄
 * @date 2022/03/26
 **/
public class Leetcode50 {
    /**
     * 利用快速幂+循环解题（基于分治法的思想）
     * @param x 给定数字
     * @param n 幂
     * @return x的n次幂
     */
    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, (long) n) : 1.0 / quickMul(x, -(long) n);
    }
    
    public double quickMul(double x, long n) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double xContribute = x;
        // 在对 n 进行二进制拆分的同时计算答案
        while (n > 0) {
            if (n % 2 == 1) {
                // 如果 n 二进制表示的最低位为 1，那么需要计入贡献
                ans = ans * xContribute;
            }
            // 将贡献不断地平方
            xContribute = xContribute * xContribute;
            // 舍弃 n 二进制表示的最低位，这样我们每次只要判断最低位即可
            n = n >> 1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Leetcode50 leetcode50 = new Leetcode50();
        double myPow = leetcode50.myPow(10, 0);
        System.out.println(myPow);
    }
}