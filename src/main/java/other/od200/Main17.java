package other.od200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 孙悟空吃蟠桃
 * @since 2024/7/17 18:02
 **/
public class Main17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = scanner.nextInt();
        if (h < nums.length) {
            System.out.println(0);
        } else {
            int left = 1;
            int right = 10000;
            int result = right;
            while (left <= right) {
                int mid = (left + right) / 2;
                int wastTime = 0;
                for (int num : nums) {
                    wastTime += (num + mid - 1) / mid;
                }
                if (wastTime <= h) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(result);
        }
    }
}
