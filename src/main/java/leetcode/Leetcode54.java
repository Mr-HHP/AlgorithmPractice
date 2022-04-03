package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author Mr.黄
 * @date 2022/04/03
 **/
public class Leetcode54 {
    /**
     * 按层模拟解题
     *
     * @param matrix 给定的矩形数组
     * @return 返回结果
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        // 行数和列数
        int rows = matrix.length;
        int columns = matrix[0].length;
        // 初始化左上角和右下角
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                // 遍历上层 (top, left)...(top, right)
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                // 遍历右层 (top + 1, right)...(bottom, right)
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    // 遍历下层 (bottom, right - 1)...(bottom, left + 1)
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    // 遍历左层 (bottom, left)...(top + 1, left)
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}