package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 测试用例执行计划
 * @since 2024/7/16 21:06
 **/
public class Main30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nList.add(Integer.parseInt(scanner.nextLine()));
        }
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int score = 0;
            Map<Integer, Integer> mMap = new HashMap<>();
            for (String k : scanner.nextLine().split(" ")) {
                score += nList.get(Integer.parseInt(k) - 1);
            }
            mMap.put(i, score);
            list.add(mMap);
        }
        list.sort((o1, o2) -> {
            int k1 = o1.keySet().stream().findFirst().get();
            int k2 = o2.keySet().stream().findFirst().get();
            int score1 = o1.get(k1);
            int score2 = o2.get(k2);
            if (score1 == score2) {
                return k1 - k2;
            } else {
                return score2 - score1;
            }
        });
        for (Map<Integer, Integer> map : list) {
            int key = map.keySet().stream().findFirst().get();
            System.out.println(key + 1);
        }
    }
}
