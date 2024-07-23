package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 反射计数
 * @since 2024/7/22 13:26
 **/
public class Main39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int sx = scanner.nextInt();
        int sy = scanner.nextInt();
        int t = scanner.nextInt();
        int[][] matrix = new int[h][w];
        for (int i = 0; i < h; i++) {
            String line = scanner.next();
            for (int j = 0; j < w; j++) {
                matrix[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        int count = matrix[y][x];
        for (int i = t; t > 0; t--) {
            x += sx;
            y += sy;
            if (x == 0 || x == w - 1) {
                sx = -sx;
            }
            if (y == 0 || y == h - 1) {
                sy = -sy;
            }
            count += matrix[y][x];
        }
        System.out.println(count);
    }
}
