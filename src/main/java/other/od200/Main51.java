package other.od200;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 亲子游戏
 * @since 2024/7/25 12:44
 **/
public class Main51 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];
        int[][] step = new int[n][n];
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == -3) {
                    startX = i;
                    startY = j;
                }
                if (matrix[i][j] == -2) {
                    endX = i;
                    endY = j;
                }
                step[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        step[startX][startY] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (step[x][y] >= step[endX][endY]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && matrix[nextX][nextY] != -1) {
                    if (step[nextX][nextY] > step[x][y] + 1) {
                        queue.add(new int[]{nextX, nextY});
                        step[nextX][nextY] = step[x][y] + 1;
                        dp[nextX][nextY] = dp[x][y] + matrix[nextX][nextY];
                    } else if (step[nextX][nextY] == step[x][y] + 1) {
                        dp[nextX][nextY] = Math.max(dp[nextX][nextY], dp[x][y] + matrix[nextX][nextY]);
                    }
                }
            }
        }
        if (step[endX][endY] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[endX][endY] + 2);
        }
    }
}
