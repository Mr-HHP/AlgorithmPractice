package other.od100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 求最多可以派出多少支团队
 * @since 2024/7/15 0:00
 **/
public class Main18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> capacities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            capacities.add(scanner.nextInt());
        }
        int minCap = scanner.nextInt();
        Collections.sort(capacities);
        int left = 0;
        int right = n - 1;
        int result = 0;
        for (; right >= left && capacities.get(right) >= minCap; right--) {
            result++;
        }
        while (left < right) {
            if (capacities.get(left) + capacities.get(right) >= minCap) {
                result++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        System.out.println(result);
    }
}
