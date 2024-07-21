package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 内存冷热标记
 * @since 2024/7/21 16:50
 **/
public class Main42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int t = Integer.parseInt(scanner.nextLine());
        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count >= t) {
                result.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        if (result.size() == 0) {
            System.out.println(0);
        } else {
            result.sort((o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            for (int[] arr : result) {
                System.out.println(arr[0]);
            }
        }
    }
}
