package other.od200;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 任务处理
 * @since 2024/7/15 21:39
 **/
public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer>[] cod = new List[100001];
        for (int i = 1; i <= 100000; i++) {
            cod[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int si = scanner.nextInt();
            int ei = scanner.nextInt();
            cod[si].add(ei);
        }
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= 100000; i++) {
            minHeap.addAll(cod[i]);
            while (!minHeap.isEmpty() && minHeap.peek() < i) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                result++;
                minHeap.poll();
            }
        }
        System.out.println(result);
    }
}
