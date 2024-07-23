package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 机器人仓库搬砖
 * @since 2024/7/23 23:44
 **/
public class Main52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int timeTop = 8;
        if (nums.length > timeTop) {
            System.out.println(-1);
        } else {
            int left = 1;
            int right = Arrays.stream(nums).max().getAsInt();
            int result = Integer.MAX_VALUE;
            while (left <= right) {
                int mid = (left + right) / 2;
                int time = 0;
                for (int num : nums) {
                    time += (num + mid - 1) / mid;
                }
                if (time <= timeTop) {
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
