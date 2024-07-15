package other;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 来自异国的客人
 * @since 2024/7/14 23:28
 **/
public class Main17 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n < m) {
                int count = 0;
                while (k > 0) {
                    int remain = k % m;
                    if (remain == n) {
                        count++;
                    }
                    k = (k - remain) / m;
                }
                System.out.println(count);
            } else {
                System.out.println(0);
            }
        } catch (Exception e) {
            System.out.println(0);
        }
    }
}
