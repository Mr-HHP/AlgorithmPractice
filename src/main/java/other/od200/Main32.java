package other.od200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 矩阵匹配
 * @since 2024/7/20 17:16
 **/
public class Main32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        List<Integer> result = new ArrayList<>();
        dfs(matrix, new boolean[m], 0, n, new ArrayList<>(), result, k);
        Collections.sort(result);
        System.out.println(result.get(k - 1));
    }

    public static void dfs(int[][] matrix, boolean[] isVisit, int start, int count, List<Integer> current, List<Integer> result, int k) {
        if (count == 0) {
            List<Integer> temp = new ArrayList<>(current);
            Collections.sort(temp);
            result.add(temp.get(temp.size() - k));
            return;
        }
        for (int i = start; i < matrix.length; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                for (int j = 0; j < matrix[i].length; j++) {
                    current.add(matrix[i][j]);
                    dfs(matrix, isVisit, i + 1, count - 1, current, result, k);
                    current.remove(current.size() - 1);
                }
                isVisit[i] = false;
            }
        }
    }
}
