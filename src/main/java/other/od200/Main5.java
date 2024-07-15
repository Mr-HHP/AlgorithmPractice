package other.od200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 项目排期
 * @since 2024/7/15 12:56
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tasks = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = scanner.nextInt();
        Arrays.sort(tasks);
        int left = tasks[tasks.length - 1];
        int right = Arrays.stream(tasks).sum();
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (backtrack(tasks, new int[n], tasks.length - 1, n, mid, new HashSet<>())) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
    public static boolean backtrack(int[] tasks, int[] loads, int index, int n, int maxLoad, HashSet<String> set) {
        if (index < 0) {
            return true;
        }
        String key = Arrays.toString(loads);
        if (set.contains(key)) {
            return false;
        }
        set.add(key);
        for (int i = 0; i < n; i++) {
            if (loads[i] + tasks[index] <= maxLoad) {
                loads[i] += tasks[index];
                if (backtrack(tasks, loads, index - 1, n, maxLoad, set)) {
                    return true;
                }
                loads[i] -= tasks[index];
            }
            if (loads[i] == 0) {
                break;
            }
        }
        return false;
    }
}
