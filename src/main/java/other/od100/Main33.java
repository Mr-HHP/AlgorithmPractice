package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 分披萨
 * @since 2024/7/16 23:28
 **/
public class Main33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long top = Long.MAX_VALUE;
        long[] subSize = new long[2 * n];
        long[][] dp = new long[2 * n + 5][2 * n + 5];
        for (int i = 0; i < n; i++) {
            subSize[i] = scanner.nextLong();
            subSize[n + i] = subSize[i];
        }
        for (long[] longs : dp) {
            Arrays.fill(longs, Long.MIN_VALUE);
        }
        long result = 0;
        for (int i = 1; i <= n; i += 2) {
            for (int left = 0, right = i - 1; right < 2 * n; left++, right++) {
                if (i == 1) {
                    dp[left][right] = subSize[left];
                } else {
                    dp[left][right] = Math.max(dp[left][right - 1] + subSize[right], dp[left + 1][right] + subSize[left]);
                }
                if (i == n) {
                    result = Math.max(result, dp[left][right]);
                }
                if (left == 0 || right == 2 * n - 1) {
                    continue;
                }
                if (subSize[left - 1] > subSize[right + 1]) {
                    dp[left - 1][right] = Math.max(dp[left - 1][right], dp[left][right]);
                } else {
                    dp[left][right + 1] = Math.max(dp[left][right + 1], dp[left][right]);
                }
            }
        }
        System.out.println(result);
    }
}
