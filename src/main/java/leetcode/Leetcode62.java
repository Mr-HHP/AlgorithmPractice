package leetcode;

/**
 * 不同路径
 *
 * @author Mr.黄
 * @date 2022/05/01
 **/
public class Leetcode62 {
    
    /**
     * 动态规划解题
     *
     * 状态转移方程：f(i,j)=f(i−1,j)+f(i,j−1)
     *
     * @param m 边界m
     * @param n 边界n
     * @return 路径条数
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}