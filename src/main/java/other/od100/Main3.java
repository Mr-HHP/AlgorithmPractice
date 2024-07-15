package other;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 用连续自然数之和来表达整数
 * @since 2024/7/13 15:02
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int nums = i + 1;
            if (2 * n % nums == 0) {
                int left = 2 * n / nums - i;
                if (left <= 0) {
                    break;
                }
                if (left % 2 == 0) {
                    result++;
                    int a = left / 2;
                    sb.setLength(0);
                    sb.append(n + "=");
                    for (int j = a; j <= a + i; j++) {
                        sb.append(j);
                        sb.append("+");
                    }
                    sb.setLength(sb.length() - 1);
                    System.out.println(sb.toString());
                }
            }
        }
        System.out.println("Result:" + result);
    }
}
