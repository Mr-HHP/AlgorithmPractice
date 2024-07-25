package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 欢乐的周末
 * @since 2024/7/25 15:29
 **/
public class Main53 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] isVisit;
    static int[][] matrix;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        matrix = new int[n][m];
        isVisit = new boolean[n][m];
        List<int[]> starts = new ArrayList<>();
        List<int[]> meets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == 2) {
                    starts.add(new int[]{i, j});
                } else if (matrix[i][j] == 3) {
                    meets.add(new int[]{i, j});
                }
            }
        }
        bfs(starts.get(0));
        int result = 0;
        if (isVisit[starts.get(1)[0]][starts.get(1)[1]]) {
            for (int[] meet : meets) {
                int x = meet[0];
                int y = meet[1];
                if (isVisit[x][y]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        isVisit[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !isVisit[nextX][nextY] && matrix[nextX][nextY] != 1) {
                    isVisit[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
