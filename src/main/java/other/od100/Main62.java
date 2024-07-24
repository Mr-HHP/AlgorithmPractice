package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 田忌赛马
 * @since 2024/7/24 16:23
 **/
public class Main62 {
    static int[] a;
    static int[] b;
    static int result = 0;
    static int maxBiggerCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        dfs(0, new boolean[a.length], 0);
        System.out.println(result);
    }

    public static void dfs(int index, boolean[] used, int biggerCount) {
        if (index >= a.length) {
            if (biggerCount > maxBiggerCount) {
                maxBiggerCount = biggerCount;
                result = 1;
            } else if (biggerCount == maxBiggerCount) {
                result++;
            }
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && a[i] == a[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            dfs(index + 1, used, biggerCount + (a[i] > b[index] ? 1 : 0));
            used[i] = false;
        }
    }
}
