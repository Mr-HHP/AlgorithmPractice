package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.黄
 * @description 螺旋矩阵
 * @since 2024/6/15 16:07
 **/
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int line = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = line - 1;
        while (left <= right && top <= bottom) {
            // 从左到右 (top, left) -> (top, right)
            for (int column = left; column <= right; column++) {
                result.add(matrix[top][column]);
            }
            // 从上到下 (right, top + 1) -> (right, bottom)
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                // 从右到左 (bottom, right - 1) -> (bottom, left)
                for (int column = right - 1; column >= left; column--) {
                    result.add(matrix[bottom][column]);
                }
                // 从下到上 (bottom - 1, left) -> (top + 1, left)
                for (int row = bottom - 1; row >= top + 1; row--) {
                    result.add(matrix[row][left]);
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return result;
    }
}
