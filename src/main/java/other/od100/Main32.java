package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 攀登者1
 * @since 2024/7/16 23:05
 **/
public class Main32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] heights = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftHeight = (i - 1 >= 0) ? heights[i - 1] : 0;
            int rightHeight = (i + 1 < heights.length) ? heights[i + 1] : 0;
            if (leftHeight < heights[i] && rightHeight < heights[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
