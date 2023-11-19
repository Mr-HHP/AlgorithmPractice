package leetcode;

public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                result[i][0] = 1;
            } else {
                // 有障碍物
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                result[0][j] = 1;
            } else {
                // 有障碍物
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                } else {
                    continue;
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
