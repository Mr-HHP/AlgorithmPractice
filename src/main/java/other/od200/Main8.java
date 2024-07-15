package other.od200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 田忌赛马
 * @since 2024/7/15 18:12
 **/
public class Main8 {
    public static int[] a;
    public static int[] b;
    public static int result = 0;
    public static int maxCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        dfs(0, new boolean[a.length], 0);
        System.out.println(result);
    }

    public static void dfs(int level, boolean[] used, int count) {
        if (level >= a.length) {
            if (count > maxCount) {
                maxCount = count;
                result = 1;
            } else if (count == maxCount) {
                result++;
            }
        } else {
            for (int i = 0; i < a.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && a[i] == a[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                dfs(level + 1, used, count + (a[i] > b[level] ? 1 : 0));
                used[i] = false;
            }
        }
    }
}
