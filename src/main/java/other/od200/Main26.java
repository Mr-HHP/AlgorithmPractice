package other.od200;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Mr.黄
 * @description 字符串拼接
 * @since 2024/7/19 17:46
 **/
public class Main26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = scanner.nextInt();
        if (str.length() > 30 || n > 5 || n <= 0) {
            System.out.println(0);
        } else {
            for (char c : str.toCharArray()) {
                if (c < 'a' || c > 'z') {
                    System.out.println(0);
                    return;
                }
            }
            boolean[] isVisit = new boolean[100];
            int dfs = dfs(new StringBuffer(), str, isVisit, n);
            System.out.println(dfs);
        }
    }

    public static int dfs(StringBuffer sb, String str, boolean[] isVisit, int n) {
        if (sb.length() == n) {
            return 1;
        }
        int count = 0;
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (isVisit[i]) {
                continue;
            }
            if (sb.length() > 0 && str.charAt(i) == sb.charAt(sb.length() - 1)) {
                continue;
            }
            if (used.contains(str.charAt(i))) {
                continue;
            }
            isVisit[i] = true;
            sb.append(str.charAt(i));
            used.add(str.charAt(i));
            count += dfs(sb, str, isVisit, n);

            isVisit[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        return count;
    }
}
