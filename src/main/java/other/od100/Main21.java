package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 数的分解
 * @since 2024/7/16 11:17
 **/
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        boolean flag = false;
        for (long m = 2; ; m++) {
            if ((2 * n) % m != 0) {
                continue;
            }
            long y = 2 * n / m - m + 1;
            if (y <= 0) {
                break;
            }
            if (y % 2 == 0) {
                flag = true;
                System.out.print(n + "=" + y/2);
                for (long x = y / 2 + 1; x < y / 2 + m; x++) {
                    System.out.print("+" + x);
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("N");
        }
    }
}
