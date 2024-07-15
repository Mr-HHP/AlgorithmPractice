package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 素数之积
 * @since 2024/7/14 15:03
 **/
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num <= 1) {
            System.out.println("-1 -1");
        } else {
            for (int i = 2; i * i <= num; i++) {
                if (isPrime(i) && num % i == 0) {
                    int other = num / i;
                    if (isPrime(other)) {
                        System.out.println(Math.min(i, other) + " " + Math.max(i, other));
                        return;
                    }
                }
            }
            System.out.println("-1 -1");
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
