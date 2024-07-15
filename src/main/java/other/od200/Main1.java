package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 分月饼
 * @since 2024/7/15 10:22
 **/
public class Main1 {
    public static int n;
    public static int m;
    public static int distributeSolutions = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();

        if (m == 1) {
            System.out.println("1");
        } else {
            distribute(0, 1, n / m, n);
            System.out.println(distributeSolutions);
        }
    }

    public static void distribute(int index, int min, int max, int remaining) {
        if (index == m - 1) {
            if (remaining - min <= 3) {
                distributeSolutions++;
            }
            return;
        }
        int current = min;
        while (current <= max) {
            remaining -= current;
            int nextMin = current;
            int nextMax = Math.min(current + 3, remaining / (m - index - 1));
            distribute(index + 1, nextMin, nextMax, remaining);
            remaining += current;
            current++;
        }

    }
}
