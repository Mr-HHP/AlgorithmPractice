package other.od200;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 寻找最优的路测线路
 * @since 2024/7/20 22:55
 **/
public class Main34 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] matrix = new int[25][25];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int left = 0;
        int right = 65535;
        int result = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(matrix, mid, r, c)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    public static boolean check(int[][] matrix, int val, int r, int c) {
        if (matrix[0][0] < val) {
            return false;
        }
        boolean[][] isVisit = new boolean[25][25];
        isVisit[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int x = head[0];
            int y = head[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && !isVisit[nextX][nextY] && matrix[nextX][nextY] >= val) {
                    isVisit[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return isVisit[r - 1][c - 1];
    }
}
