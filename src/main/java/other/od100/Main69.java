package other.od100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 剩余银饰的重量
 * @since 2024/7/24 23:30
 **/
public class Main69 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            queue.add(x);
        }
        while (queue.size() >= 3) {
            int z = queue.poll();
            int y = queue.poll();
            int x = queue.poll();
            int result = help(x, y, z);
            if (result != 0) {
                queue.add(result);
            }
        }
        int result = queue.size() != 0 ? queue.peek() : 0;
        System.out.println(result);
    }

    public static int help(int x, int y, int z) {
        int result = 0;
        if (y - x > 0 && z - y > 0) {
            result = Math.abs(z - y - (y - x));
        } else if (y - x > 0) {
            result = y - x;
        } else if (z - y > 0) {
            result = z - y;
        }
        return result;
    }
}
