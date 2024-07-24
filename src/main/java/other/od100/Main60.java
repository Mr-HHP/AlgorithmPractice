package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 小明找位置
 * @since 2024/7/24 16:06
 **/
public class Main60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = scanner.nextInt();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > x) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
