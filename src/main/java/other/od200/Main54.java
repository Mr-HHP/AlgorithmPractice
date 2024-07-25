package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 找数字
 * @since 2024/7/25 16:00
 **/
public class Main54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = n;
        int count0 = 0;
        int count1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            count0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {
            count1++;
            c >>= 1;
        }
        if (count0 + count1 == 31 || count0 + count1 == 0) {
            System.out.println("-1");
            return;
        }
        int index = count0 + count1;
        n |= (1 << index);
        n &= -(1 << index);
        n |= (1 << (count1 - 1)) - 1;
        System.out.println(n);
    }
}
