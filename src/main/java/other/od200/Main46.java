package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 路口最短时间间隔
 * @since 2024/7/23 11:03
 **/
public class Main46 {
    static int[][] offsets = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int timePerRoad = scanner.nextInt();
        int rowStart = scanner.nextInt();
        int colStart = scanner.nextInt();
        int rowEnd = scanner.nextInt();
        int colEnd = scanner.nextInt();
        System.out.println(caclTime(matrix, timePerRoad, rowStart, colStart, rowEnd, colEnd));
    }

    public static int caclTime(int[][] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd) {
        int n = lights.length;
        int m = lights[0].length;
        int[][][] dp = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < 4; i++) {
            dp[rowStart][colStart][i] = 0;
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < 4; i++) {
            queue.offer(new int[]{0, rowStart, colStart, -1, -1, i});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int v = current[0];
            int x = current[1];
            int y = current[2];
            int px = current[3];
            int py = current[4];
            int direction = current[5];
            for (int i = 0; i < 4; i++) {
                int nextX = x + offsets[i][0];
                int nextY = y + offsets[i][1];
                if (!(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) || (nextX == px && nextY == py)) {
                    continue;
                }
                int newCost = v + timePerRoad;
                if ((direction + 1) % 4 != i) {
                    newCost += lights[x][y];
                }
                if (newCost < dp[nextX][nextY][i]) {
                    dp[nextX][nextY][i] = newCost;
                    queue.offer(new int[]{newCost, nextX, nextY, x, y, i});
                }
            }
        }
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minTime = Math.min(minTime, dp[rowEnd][colEnd][i]);
        }
        return minTime;
    }
}
