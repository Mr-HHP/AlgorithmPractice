package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 园区参观路径
 * @since 2024/7/19 22:55
 **/
public class Main29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            System.out.println(0);
        }
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] + dp[i][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
