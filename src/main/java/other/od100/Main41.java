package other.od100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Mr.黄
 * @description 精准核算检测
 * @since 2024/7/21 12:32
 **/
public class Main41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] diagnosis = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> diagnosisSet = new HashSet<>();
        for (int i : diagnosis) {
            diagnosisSet.add(i);
        }
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            for (int j = 0; j < split.length; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
        boolean[] isVisit = new boolean[n];
        for (int index : diagnosisSet) {
            if (!isVisit[index]) {
                dfs(matrix, isVisit, index);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isVisit[i] && !diagnosisSet.contains(i)) {
                count++;
            }
        }

        System.out.println(count);

    }

    public static void dfs(int[][] matrix, boolean[] isVisit, int index) {
        isVisit[index] = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[index][i] == 1 && !isVisit[i]) {
                dfs(matrix, isVisit, i);
            }
        }
    }
}
