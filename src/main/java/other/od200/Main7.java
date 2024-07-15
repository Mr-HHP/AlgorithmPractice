package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 可以组成的网络服务器
 * @since 2024/7/15 17:34
 **/
public class Main7 {
    public static int[] xDirection = {0, 0, 1, -1};
    public static int[] yDirection = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        boolean[][] isVisit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !isVisit[i][j]) {
                    result = Math.max(result, dfs(i, j, map, isVisit, n, m));
                }
            }
        }
        System.out.println(result);
    }

    public static int dfs(int x, int y, int[][] map, boolean[][] isVisit, int n, int m) {
        isVisit[x][y] = true;
        int result = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + xDirection[i];
            int nextY = y + yDirection[i];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                continue;
            }
            if (map[nextX][nextY] == 1 && !isVisit[nextX][nextY]) {
                result += dfs(nextX, nextY, map, isVisit, n, m);
            }
        }
        return result;
    }
}
