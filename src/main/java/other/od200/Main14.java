package other.od200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Mr.黄
 * @description Wonderland
 * @since 2024/7/17 13:08
 **/
public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] costs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] plan = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lastDay = plan[plan.length - 1];
        int[] dp = new int[lastDay + 1];
        Set<Integer> daySet = new HashSet<>();
        for (int day : plan) {
            daySet.add(day);
        }
        for (int day = 1; day <= lastDay; day++) {
            if (!daySet.contains(day)) {
                dp[day] = dp[day - 1];
            } else {
                int cost1 = dp[Math.max(0, day - 1)] + costs[0];
                int cost3 = dp[Math.max(0, day - 3)] + costs[1];
                int cost7 = dp[Math.max(0, day - 7)] + costs[2];
                int cost30 = dp[Math.max(0, day - 30)] + costs[3];
                dp[day] = Math.min(Math.min(cost1, cost3), Math.min(cost7, cost30));
            }
        }
        System.out.println(dp[lastDay]);
    }
}
