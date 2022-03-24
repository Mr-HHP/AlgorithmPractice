package leetcode;

/**
 * 旋转图像
 *
 * @author Mr.黄
 * @date 2022/03/25
 **/
public class Leetcode48 {
    /**
     * 通过两次翻转解题，水平翻转 + 主对角线翻转
     *
     * @param matrix 给定的矩形
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    /**
     * 通过公式推算解题
     *
     * temp=matrix[row][col]
     * matrix[row][col]=matrix[n−col−1][row]
     * matrix[n−col−1][row]=matrix[n−row−1][n−col−1]
     * matrix[n−row−1][n−col−1]=matrix[col][n−row−1]
     * matrix[col][n−row−1]=temp
     *
     * @param matrix 给定的矩形
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}