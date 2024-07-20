package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 分配土地
 * @since 2024/7/20 21:58
 **/
public class Main37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[501];
        int[] maxRow = new int[501];
        int[] minRow = new int[501];
        int[] maxCol = new int[501];
        int[] minCol = new int[501];
        Arrays.fill(maxRow, Integer.MIN_VALUE);
        Arrays.fill(minRow, Integer.MAX_VALUE);
        Arrays.fill(maxCol, Integer.MIN_VALUE);
        Arrays.fill(minCol, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                nums[num] = 1;
                maxRow[num] = Math.max(maxRow[num], i);
                minRow[num] = Math.min(minRow[num], i);
                maxCol[num] = Math.max(maxCol[num], j);
                minCol[num] = Math.min(minCol[num], j);
            }
        }
        int maxArea = 0;
        for (int i = 1; i < 501; i++) {
            if (nums[i] == 1) {
                maxArea = Math.max(maxArea, (maxRow[i] - minRow[i] + 1) * (maxCol[i] - minCol[i] + 1));
            }
        }
        System.out.println(maxArea);
    }
}
