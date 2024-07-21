package other.od200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 贪吃的猴子
 * @since 2024/7/21 23:32
 **/
public class Main37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[length + 5];
        int[] pre = new int[length + 5];
        for (int i = 1; i <= length; i++) {
            numbers[i] = scanner.nextInt();
            pre[i] = pre[i - 1] + numbers[i];
        }
        int n = scanner.nextInt();
        int result = Integer.MIN_VALUE;
        for (int left = 0; left <= n; left++) {
            int right = n - left;
            int temp = pre[left] + (pre[length] - pre[length - right]);
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }
}
