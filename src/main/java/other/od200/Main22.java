package other.od200;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 贪心歌手
 * @since 2024/7/17 20:44
 **/
public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int t = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[] travelDays = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] m = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }
        int pathTime = Arrays.stream(travelDays).sum();
        int remain = t - pathTime;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int days = 0;
            while (true) {
                int earningsToday = Math.max(m[i] - days * d[i], 0);
                if (queue.size() < remain) {
                    queue.offer(earningsToday);
                } else {
                    if (!queue.isEmpty() && earningsToday > queue.peek()) {
                        queue.poll();
                        queue.offer(earningsToday);
                    }
                }
                if (earningsToday == 0) {
                    break;
                }
                days++;
            }
        }
        int maxEarnings = 0;
        for (int earnings : queue) {
            maxEarnings += earnings;
        }
        System.out.println(maxEarnings);
    }
}
