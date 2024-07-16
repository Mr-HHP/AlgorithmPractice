package other.od100;

import java.util.*;
import java.util.function.Function;

/**
 * @author Mr.黄
 * @description 执行任务赚积分
 * @since 2024/7/16 16:17
 **/
public class Main26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        List<Integer>[] lists = new List[t + 1];
        for (int i = 0; i < t + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int end = scanner.nextInt();
            int score = scanner.nextInt();
            lists[Math.min(end, t)].add(score);
        }
        int totalScore = 0;
        List<Integer> waitList = new ArrayList<>();
        for (int i = t; i > 0; i--) {
            waitList.addAll(lists[i]);
            if (!waitList.isEmpty()) {
                Collections.sort(waitList);
                totalScore += waitList.remove(waitList.size() - 1);
            }
        }
        System.out.println(totalScore);
    }
}
