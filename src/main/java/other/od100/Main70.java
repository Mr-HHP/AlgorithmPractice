package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 查找众数及中位数
 * @since 2024/7/24 23:59
 **/
public class Main70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        for (int count : countMap.values()) {
            if (count >= maxCount) {
                maxCount = count;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        if (list.size() % 2 != 0) {
            int index = (list.size() + 1) / 2 - 1;
            System.out.println(list.get(index));
        } else {
            int index1 = list.size() / 2 - 1;
            int index2 = list.size() / 2;
            System.out.println((list.get(index1) + list.get(index2)) / 2);
        }
    }
}
