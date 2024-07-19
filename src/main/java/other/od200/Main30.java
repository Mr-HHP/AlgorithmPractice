package other.od200;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 快递员的烦恼
 * @since 2024/7/19 23:40
 **/
public class Main30 {
    static int num = 1;
    static int result = Integer.MAX_VALUE;
    static boolean[] isVisit = new boolean[15];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] hash = new int[1010];
        Arrays.fill(hash, -1);
        int[][] path = new int[15][15];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            int distance = scanner.nextInt();
            if (hash[id] == -1) {
                hash[id] = num++;
            }
            int index = hash[id];
            path[0][index] = Math.min(distance, path[0][index]);
            path[index][0] = path[0][index];
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int distance = scanner.nextInt();
            x = hash[x];
            y = hash[y];
            path[x][y] = Math.min(path[x][y], distance);
            path[y][x] = path[x][y];
        }
        for (int i = 0; i < num; i++) {
            path[i][i] = 0;
        }
        for (int k = 0; k < num; k++) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
                }
            }
        }
        dfs(0, 0, 0, path);
        System.out.println(result);
    }

    public static void dfs(int u, int k, int t, int[][] path) {
        if (k > result) {
            return;
        }
        if (t == num - 1) {
            result = Math.min(result, k + path[u][0]);
        }
        for (int i = 1; i < num; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                dfs(i, k + path[u][i], t + 1, path);
                isVisit[i] = false;
            }
        }
    }
}
