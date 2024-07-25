package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 启动多任务排序
 * @since 2024/7/25 14:20
 **/
public class Main52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<String>> map = new TreeMap<>();
        TreeMap<String, Integer> inDegree = new TreeMap<>();
        String[] split = scanner.nextLine().split(" ");
        for (String s : split) {
            String[] nodes = s.split("->");
            String u = nodes[1];
            String v = nodes[0];
            inDegree.put(u, inDegree.getOrDefault(u, 0));
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(u).add(v);
        }
        TreeSet<String> set = new TreeSet<>();
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            String u = entry.getKey();
            if (entry.getValue() == 0) {
                set.add(u);
            }
        }
        while (set.size() > 0) {
            result.addAll(set);
            TreeSet<String> next = new TreeSet<>();
            for (String u : set) {
                for (String v : map.get(u)) {
                    inDegree.put(v, inDegree.get(v) - 1);
                    if (inDegree.get(v) == 0) {
                        next.add(v);
                    }
                }
            }
            set = new TreeSet<>(next);
        }
        for (String u : result) {
            System.out.print(u + " ");
        }
    }
}
