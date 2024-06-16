package leetcode2;

/**
 * @author Mr.黄
 * @description 矩阵置零
 * @since 2024/6/15 14:24
 **/
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        int[] line = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    line[i] = column[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (line[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
