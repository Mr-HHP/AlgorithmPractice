package other.od200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 智能驾驶
 * @since 2024/7/22 23:48
 **/
public class Main45 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] nums = scanner.nextLine().split(",");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int[][] dp = new int[n][m];
        boolean[][] isVisit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisit[i], false);
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n - 1, m - 1});
        dp[n - 1][m - 1] = matrix[n - 1][m - 1];
        isVisit[n - 1][m - 1] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            isVisit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || matrix[nextX][nextY] == 0) {
                    continue;
                }
                int nextValue = 0;
                if (matrix[nextX][nextY] > 0) {
                    nextValue = dp[x][y] + matrix[nextX][nextY];
                }
                if (nextValue > 100) {
                    continue;
                }
                if (dp[nextX][nextY] > nextValue) {
                    dp[nextX][nextY] = nextValue;
                    if (!isVisit[nextX][nextY]) {
                        isVisit[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        int result = -1;
        if (dp[0][0] <= 100) {
            result = dp[0][0];
        }
        System.out.println(result);
    }
}
