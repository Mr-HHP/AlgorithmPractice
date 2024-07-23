package other.od100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 求幸存数之和
 * @since 2024/7/23 21:09
 **/
public class Main49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int jump = Integer.parseInt(scanner.nextLine());
        int left = Integer.parseInt(scanner.nextLine());
        System.out.println(sumOfLeft(nums, jump, left));
    }

    public static int sumOfLeft(int[] nums, int jump, int left) {
        if (left > nums.length) {
            return Arrays.stream(nums).sum();
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int index = 0;
        while (list.size() > left) {
            index = (index + jump + 1) % list.size();
            list.remove(index);
            index = index - 1;
        }
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
