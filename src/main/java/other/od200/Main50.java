package other.od200;

import java.util.*;
import java.util.function.Function;

/**
 * @author Mr.黄
 * @description 会议室占用时间
 * @since 2024/7/23 14:45
 **/
public class Main50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new int[]{start, end});
        }
        if (!intervals.isEmpty()) {
            intervals.sort(Comparator.comparingInt(o -> o[0]));
            List<int[]> merged = new ArrayList<>();
            for (int[] interval : intervals) {
                if (!merged.isEmpty() && interval[0] <= merged.get(merged.size() - 1)[1]) {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                } else {
                    merged.add(interval);
                }
            }
            for (int[] interval : merged) {
                System.out.print(interval[0] + " " + interval[1]);
                System.out.println();
            }
        }
    }
}
