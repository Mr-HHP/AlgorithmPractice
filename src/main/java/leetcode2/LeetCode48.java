package leetcode2;

/**
 * @author Mr.黄
 * @description 旋转图像
 * @since 2024/6/16 13:35
 **/
public class LeetCode48 {
    // 原地反转，无需辅助空间
    public void rotate(int[][] matrix) {
        int line = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < line / 2; i++) {
            for (int j = 0; j < (columns + 1) / 2; j++) {
                // 对应公式 (i, j) => (j, line - i - 1)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[line - j - 1][i];
                matrix[line - j - 1][i] = matrix[line - i - 1][line - j - 1];
                matrix[line - i - 1][line - j - 1] = matrix[j][line - i -1];
                matrix[j][line - i -1] = temp;
            }
        }
    }

    // 需要辅助空间
    public void rotate2(int[][] matrix) {
        int line = matrix.length - 1;
        int columns = matrix[0].length;
        int[][] matrix2 = new int[line][columns];
        for (int i = 0; i <= line; i++) {
            for (int j = 0; j < columns; j++) {
                matrix2[j][line - i] = matrix[i][j];
            }
        }
        for (int i = 0; i <= line; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = matrix2[i][j];
            }
        }
    }
}
