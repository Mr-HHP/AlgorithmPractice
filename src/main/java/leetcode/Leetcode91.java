package leetcode;

/**
 * 解码方法
 *
 * @author Mr.黄
 * @date 2022/05/03
 **/
public class Leetcode91 {
    /**
     * 使用动态规划解题
     * 状态转移方程：
     * f[i]=f[i−1],1⩽a≤9
     * f[i]=f[i−2],10⩽b⩽26
     * f[i]=f[i−1]+f[i−2],1⩽a≤9,10⩽b⩽26
     *
     * @param s 给定数字
     * @return 解码方案数
     */
    public int numDecodings(String s) {
        int n = s.length();
        // 使用空格作为哨兵，避免讨论前导0，也能使下标从1开始，简化f(i-1)的负数下标判断
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] f = new int[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i % 3] = 0;
            // a：代表当前位置单独形成item
            int a = chars[i] - '0';
            // b：代表当前位置与前一位置共同形成item
            int b = (chars[i] - '0') + (chars[i - 1] - '0') * 10;
            if (a >= 1 && a <= 9) {
                f[i % 3] = f[(i - 1) % 3];
            }
            if (b >= 10 && b <= 26) {
                f[i % 3] = f[(i - 2) % 3];
            }
            if (a >= 1 && a <= 9 && b >= 10 && b <= 26) {
                f[i % 3] = f[(i - 1) % 3] + f[(i - 2) % 3];
            }
        }
        return f[n % 3];
    }
}