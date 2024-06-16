package leetcode2;

/**
 * @author Mr.黄
 * @description 搜索二维矩阵
 * @since 2024/6/16 14:58
 **/
public class LeetCode240 {
    // 二分查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == arr[mid]) {
                    return true;
                } else if (target > arr[mid]) {
                    left = mid + 1;
                } else if (target < arr[mid]) {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


    // 直接查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int line = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
