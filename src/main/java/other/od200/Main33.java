package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 图像物体的边界
 * @since 2024/7/20 18:13
 **/
public class Main33 {
    public static boolean[][] isWall;
    public static boolean[][] isVisit;
    public static int[][] matrix;
    public static int[] dx = {0, 0, 1, 1, -1, -1, 1, -1};
    public static int[] dy = {1, -1, 1, -1, 1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        matrix = new int[m][n];
        isWall = new boolean[m][n];
        isVisit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == 5) {
                    isWall[i][j] = false;
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] != 5) {
                            isWall[x][y] = true;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWall[i][j] && !isVisit[i][j]) {
                    count++;
                    dfs(i, j, m, n);
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int x, int y, int m, int n) {
        isVisit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && isWall[nextX][nextY] && !isVisit[nextX][nextY]) {
                dfs(nextX, nextY, m, n);
            }
        }
    }
}
