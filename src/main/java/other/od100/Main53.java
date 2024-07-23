package other.od100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mr.黄
 * @description 数组去重和排序
 * @since 2024/7/23 23:53
 **/
public class Main53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(",");
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> first = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            first.putIfAbsent(nums[i], i);
        }
        List<String> result = first
                .keySet()
                .stream()
                .sorted((o1, o2) -> {
                    int count1 = count.get(o1);
                    int count2 = count.get(o2);
                    if (count1 != count2) {
                        return count2 - count1;
                    } else {
                        int first1 = first.get(o1);
                        int first2 = first.get(o2);
                        return first1 - first2;
                    }
                })
                .collect(Collectors.toList());
        System.out.println(String.join(",", result));
    }
}
