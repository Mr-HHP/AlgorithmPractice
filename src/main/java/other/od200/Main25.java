package other.od200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 员工派遣
 * @since 2024/7/19 16:20
 **/
public class Main25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = array[0];
        int y = array[1];
        int countX = array[2];
        int countY = array[3];
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (true) {
            if (left >= right) {
                break;
            } else {
                int mid = (left + right) / 2;
                int a = mid / x;
                int b = mid / y;
                int c = mid / (x * y);
                int target = Math.max(0, countX - (b - c)) + Math.max(0, countY - (a - c));
                if (mid - (a + b - c) >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(left);
    }
}
