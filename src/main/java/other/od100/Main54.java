package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 找座位
 * @since 2024/7/24 0:02
 **/
public class Main54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && (i == 0 || nums[i - 1] == 0) && (i == nums.length - 1 || nums[i + 1] == 0)) {
                nums[i] = 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
