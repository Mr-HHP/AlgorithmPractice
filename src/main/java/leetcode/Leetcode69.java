package leetcode;

/**
 * x的平方根
 *
 * @author Mr.黄
 * @date 2022/03/22
 **/
public class Leetcode69 {
    /**
     * 袖珍计算器算法（利用数学公式变相的替换推导求平方根）
     *
     * @param x 给定的非负整数x
     * @return x的平方根
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
    
    /**
     * 二分查找解题
     *
     * @param x 给定的非负整数
     * @return x的平方根
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}