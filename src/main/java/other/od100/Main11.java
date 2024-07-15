package other.od100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;

/**
 * @author Mr.黄
 * @description 查找接口成功率最优时间段
 * @since 2024/7/14 17:29
 **/
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minAvgLost = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array.length;
        int[] prefixSum = new int[n + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
            min = Math.min(min, array[i - 1]);
        }
        if (min > minAvgLost) {
            System.out.println("NULL");
            return;
        }
        List<int[]> result = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            for (int left = 1, right = i; right <= n; left++, right++) {
                 int sum = prefixSum[right] - prefixSum[left - 1];
                 if (sum <= minAvgLost * i) {
                     result.add(new int[]{left, right});
                 }
            }
            if (result.size() > 0) {
                break;
            }
        }
        for (int[] arr : result) {
            System.out.println(arr[0] - 1 + "-" + (arr[1] - 1) + " ");
        }
    }
}
