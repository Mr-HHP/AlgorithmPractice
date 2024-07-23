package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 螺旋数字矩阵
 * @since 2024/7/23 17:04
 **/
public class Main45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int column = (n + m - 1) / m;
        String[][] matrix = new String[m][column];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], "*");
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int directory = 0;
        int currentNum = 1;
        while (currentNum <= n) {
            matrix[x][y] = Integer.toString(currentNum);
            if (currentNum == n) {
                break;
            }
            int nextX;
            int nextY;
            while (true) {
                nextX = x + dx[directory];
                nextY = y + dy[directory];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= column || !"*".endsWith(matrix[nextX][nextY])) {
                    directory = (directory + 1) % 4;
                } else {
                    break;
                }
            }
            x = nextX;
            y = nextY;
            currentNum++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
