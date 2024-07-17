package other.od200;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Mr.黄
 * @description 考古学家
 * @since 2024/7/17 21:29
 **/
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> treeSet = new TreeSet<>();
        boolean[] isVisit = new boolean[n];
        String[] values = scanner.nextLine().split(" ");
        dfs(0, values, isVisit, new StringBuffer(), treeSet, n);
        for (String s : treeSet) {
            System.out.println(s);
        }
    }

    public static void dfs(int count, String[] values, boolean[] isVisit, StringBuffer sb, TreeSet treeSet, int n) {
        if (count == n) {
            treeSet.add(sb.toString());
        } else {
            for (int i = 0; i < n; i++) {
                if (!isVisit[i]) {
                    isVisit[i] = true;
                    sb.append(values[i]);
                    dfs(count + 1, values, isVisit, sb, treeSet, n);
                    isVisit[i] = false;
                    sb.delete(sb.length() - values[i].length(), sb.length());
                }
            }
        }
    }
}
