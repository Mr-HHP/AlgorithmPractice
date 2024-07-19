package other.od200;

import java.util.*;
import java.util.function.Function;

/**
 * @author Mr.黄
 * @description 查找一个有向网络的头节点和尾节点
 * @since 2024/7/19 18:02
 **/
public class Main27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }
//        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
//            graph.computeIfAbsent(u, i -> new ArrayList<>()).add(v);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
            inDegree.putIfAbsent(u, 0);
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            outDegree.putIfAbsent(v, 0);
        }
        boolean isCycle = true;
        int head = 0;
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            Integer u = entry.getKey();
            if (entry.getValue() == 0) {
                head = u;
                isCycle = false;
            }
        }
        if (isCycle) {
            System.out.println(-1);
            return;
        }
        List<Integer> tailNodes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : outDegree.entrySet()) {
            if (entry.getValue() == 0) {
                tailNodes.add(entry.getKey());
            }
        }
        Collections.sort(tailNodes);
        System.out.print(head + " ");
        for (int node : tailNodes) {
            System.out.print(node + " ");
        }
    }
}
