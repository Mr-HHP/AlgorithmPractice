package other.od100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 传递悄悄话
 * @since 2024/7/24 15:19
 **/
public class Main59 {
    static int result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int father = queue.poll();
            check(2 * father + 1, nums, father, queue);
            check(2 * father + 2, nums, father, queue);
        }
        System.out.println(result);
    }

    public static void check(int index, int[] nums, int father, Queue<Integer> queue) {
        if (index < nums.length && nums[index] != -1) {
            nums[index] += nums[father];
            queue.add(index);
            if (nums[index] > result) {
                result = nums[index];
            }
        }
    }
}
