package other.od100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 特殊的加密算法
 * @since 2024/7/24 17:04
 **/
public class Main66 {
    static int[] data;
    static int[][] book;
    static boolean[][] isVisit;
    static List<int[]> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        book = new int[m][m];
        isVisit = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                book[i][j] = scanner.nextInt();
            }
        }
        boolean find = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (data[0] == book[i][j]) {
                    if (dfs(i, j, 0, n, m)) {
                        find = true;
                        break;
                    }
                }
            }
            if (find) {
                break;
            }
        }
        if (!find || result.isEmpty()) {
            System.out.println("error");
        } else {
            for (int[] x : result) {
                System.out.print(x[0] + " " + x[1] + " ");
            }
        }
    }

    public static boolean dfs(int x, int y, int k, int n, int m) {
        isVisit[x][y] = true;
        result.add(new int[]{x, y});
        if (k == n - 1) {
            return true;
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < m && !isVisit[nextX][nextY] && book[nextX][nextY] == data[k + 1]) {
                if (dfs(nextX, nextY, k + 1, n, m)) {
                    return true;
                }
            }
        }
        result.remove(result.size() - 1);
        isVisit[x][y] = false;
        return false;
    }
}
