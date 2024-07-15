package other.od100;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;

/**
 * @author Mr.黄
 * @description 最大坐标值
 * @since 2024/7/14 15:54
 **/
public class Main9 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n < 1 || n > 100 || m < -100 || m > 100) {
                throw new Exception();
            }
            int[] commands = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                int command = scanner.nextInt();
                if (command > 100 || command < -100) {
                    throw new Exception();
                }
                commands[i] = command;
            }
            int[] point = new int[n + 1];
            point[0] = 0;
            for (int i = 1; i < n + 1; i++) {
                int command = commands[i];
                if (m == command) {
                    if (command > 0) {
                        point[i] = point[i - 1] + commands[i] + 1;
                    } else if (command == 0) {
                        point[i] = point[i - 1] + 1;
                    } else {
                        point[i] = point[i - 1] + commands[i] - 1;
                    }
                } else {
                    point[i] = point[i - 1] + commands[i];
                }
            }
            Arrays.sort(point);
            System.out.println(point[n]);
        } catch (Exception e) {
            System.out.println(12345);
        }
    }
}
