package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 小华最多能得到多少克黄金
 * @since 2024/7/20 22:26
 **/
public class Main38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        if (m == 0 || n == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < m; i++) {
                int sum1 = 0;
                String[] splitM = String.valueOf(i).split("");
                for (String num : splitM) {
                    sum1 += Integer.parseInt(num);
                }
                if (sum1 > k) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    String[] splitN = String.valueOf(j).split("");
                    int sum2 = 0;
                    for (String num : splitN) {
                        sum2 += Integer.parseInt(num);
                    }
                    if (sum2 > k) {
                        continue;
                    }
                    if (sum1 + sum2 <= k) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
