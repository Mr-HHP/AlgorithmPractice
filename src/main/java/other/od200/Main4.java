package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 电脑病毒感染
 * @since 2024/7/15 12:08
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int time = scanner.nextInt();
            List<int[]> list = graph.get(u);
            list.add(new int[]{time, v});
        }
        int start = scanner.nextInt();

        boolean[] isVisit = new boolean[n + 1];
        int[] minDis = new int[n + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        queue.add(new int[]{0, start});
        minDis[start] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[1];
            if (isVisit[u]) {
                continue;
            }
            isVisit[u] = true;

            for (int[] next : graph.get(u)) {
                int time = next[0];
                int v = next[1];
                if (minDis[u] + time < minDis[v]) {
                    minDis[v] = minDis[u] + time;
                    queue.add(new int[]{minDis[v], v});
                }
            }
        }
        int result = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, minDis[i]);
            count += isVisit[i] ? 1 : 0;
        }
        if (count < n) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
}
