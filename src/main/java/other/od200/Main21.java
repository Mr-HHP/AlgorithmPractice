package other.od200;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 抢7游戏
 * @since 2024/7/17 20:16
 **/
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        BigInteger[] a = new BigInteger[10010];
        BigInteger[] b = new BigInteger[10010];
        for (int i = 0; i < 10010; i++) {
            a[i] = BigInteger.ZERO;
            b[i] = BigInteger.ZERO;
        }
        a[m] = BigInteger.ONE;
        for (int i = m; i > 7; i--) {
            for (int j = 1; j < 3; j++) {
                a[i - j] = a[i - j].add(b[i]);
                b[i - j] = b[i - j].add(a[i]);
            }
        }
        System.out.println(b[7]);
    }
}
