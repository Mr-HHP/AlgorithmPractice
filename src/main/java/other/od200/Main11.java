package other.od200;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 最小矩阵宽度
 * @since 2024/7/15 23:04
 **/
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] map = new int[1001];
        for (int num : arr) {
            map[num]++;
        }
        int width = Integer.MAX_VALUE;
        boolean[][] dp = new boolean[m][m];
        for (boolean[] init : dp) {
            Arrays.fill(init, true);
        }
        for (int left = 0; left < m; left++) {
            for (int right = left; right < m; right++) {
                if (right > left && !dp[left][right]) {
                    continue;
                }
                if (right - left > width) {
                    continue;
                }
                if (help(matrix, map, left, right)) {
                    width = Math.min(width, right - left + 1);
                } else {
                    for (int r = right; r >= left; r--) {
                        dp[r][right] = false;
                    }
                }
            }
        }
        if (width == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(width);
        }
    }

    public static boolean help(int[][] matrix, int[] map, int left, int right) {
        int[] numCount = new int[1001];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = left; j <= right; j++) {
                numCount[matrix[i][j]]++;
            }
        }
        boolean flag = true;
        for (int i = 0; i < 1001; i++) {
            if (numCount[i] < map[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
