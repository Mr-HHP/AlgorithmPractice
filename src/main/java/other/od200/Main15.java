package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 跳马
 * @since 2024/7/17 13:35
 **/
public class Main15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String[] chessboard = new String[m];
        int[][][] dp = new int[900][30][30];
        for (int i = 0; i < 900; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 30; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            chessboard[i] = scanner.next();
        }
        int horseTotal = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (chessboard[x].charAt(y) == '.') {
                    continue;
                }
                int k = chessboard[x].charAt(y) - '0';
                horseTotal++;
                dfs(horseTotal, x, y, 0, k, dp, m, n);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int sum = 0;
                for (int i = 1; i <= horseTotal; i++) {
                    sum += dp[i][x][y];
                }
                result = Math.min(sum, result);
            }
        }
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    public static void dfs(int id, int x, int y, int val, int k, int[][][] dp, int m, int n) {
        if (k < 0 || dp[id][x][y] <= val) {
            return;
        }
        dp[id][x][y] = val;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }
            dfs(id, nextX, nextY, val + 1, k - 1, dp, m, n);
        }
    }
}
