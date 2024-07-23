package other.od200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 跳格子3
 * @since 2024/7/23 12:26
 **/
public class Main47 {
    public static int[] scores;
    public static long[] dp;
    public static Deque<Integer> deque = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        dp = new long[n];
        dp[0] = scores[0];
        deque.offer(0);
        for (int i = 1; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k) {
                deque.poll();
            }
            dp[i] = dp[deque.peek()] + scores[i];
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        System.out.println(dp[n - 1]);
    }
}
