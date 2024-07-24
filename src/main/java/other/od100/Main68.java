package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 最大N个数与最小N个数的和
 * @since 2024/7/24 22:59
 **/
public class Main68 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            treeSet.add(num);
            if (num < 0 || num > 1000) {
                flag = false;
            }
        }
        int n = scanner.nextInt();
        if (n < 0) {
            flag = false;
        }
        if (treeSet.size() < 2 * n || !flag) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        Iterator<Integer> iterator = treeSet.iterator();
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        for (int i = 0; i < n; i++) {
            sum += iterator.next();
            sum += descendingIterator.next();
        }
        System.out.println(sum);
    }
}
