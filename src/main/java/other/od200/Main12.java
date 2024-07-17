package other.od200;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Mr.黄
 * @description 部门人力分配
 * @since 2024/7/17 11:11
 **/
public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int[] requirements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int requirement : requirements) {
            treeMap.put(requirement, treeMap.getOrDefault(requirement, 0) + 1);
        }
        int left = treeMap.lastKey();
        int right = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            TreeMap<Integer, Integer> map = new TreeMap<>(treeMap);
            int needMonthNum = 0;
            while (map.size() > 0) {
                needMonthNum++;
                int current = map.firstKey();
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    map.remove(current);
                }
                if (map.size() > 0) {
                    Integer next = map.floorKey(mid - current);
                    if (next != null) {
                        map.put(next, map.get(next) - 1);
                        if (map.get(next) == 0) {
                            map.remove(next);
                        }
                    }
                }
            }
            if (needMonthNum <= m) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
