package other.od200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 找城市
 * @since 2024/7/15 10:47
 **/
public class Main2 {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            List<Integer> listU = graph.get(u);
            List<Integer> listV = graph.get(v);
            listU.add(v);
            listV.add(u);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> list = graph.get(i);
            for (int currentCity : list) {
                dp[i] = Math.max(dp[i], dfs(currentCity, i));
            }
        }
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minVal = Math.min(minVal, dp[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            if (dp[i] == minVal) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static int dfs(int currentCity, int father) {
        int count = 1;
        List<Integer> list = graph.get(currentCity);
        for (int v : list) {
            if (v == father) {
                continue;
            }
            count += dfs(v, currentCity);
        }
        return count;
    }
}
