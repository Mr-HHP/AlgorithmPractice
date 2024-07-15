package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 两个字符串间的最短路径问题
 * @since 2024/7/15 11:41
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String s1 = "0" + strings[0];
        String s2 = "0" + strings[1];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
