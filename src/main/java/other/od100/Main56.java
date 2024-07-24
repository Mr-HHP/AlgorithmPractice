package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 小明找位置
 * @since 2024/7/24 14:08
 **/
public class Main56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int x = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= x) {
                result = i;
                break;
            }
        }
        System.out.println(result + 1);
    }
}
