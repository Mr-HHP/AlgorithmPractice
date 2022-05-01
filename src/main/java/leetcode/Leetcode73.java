package leetcode;

import javafx.concurrent.Worker;

/**
 * 矩阵置零
 *
 * @author Mr.黄
 * @date 2022/05/01
 **/
public class Leetcode73 {
    public static void main(String[] args) {
        Leetcode73 leetcode73 = new Leetcode73();
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        leetcode73.setZeroes(matrix);
    }
    
    /**
     * 使用两个标记变量解题
     *
     * @param matrix 矩阵
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // 扫描“首行”和“首列”，记录“首行”和“首列”是否该背置零
        boolean r0 = false, c0 = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                r0 = true;
                break;
            }
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                c0 = true;
                break;
            }
        }
        // 扫描“非首行首列”的位置，如果发现零，将需要置零的信息存储到该行的“最左方”和“最上方”的格子内
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 根据刚刚记录在“最左方”和“最上方”的格子内的置零信息，进行“非首行首列”的置零
        for (int i = 1; i < row; i++) {
           for (int j = 1; j < col; j++) {
               if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                   matrix[i][j] = 0;
               }
           }
        }
        // 根据最开始记录的“首行”和“首列”信息，进行“首行首列”置零
        if (r0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (c0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
    }
    
}