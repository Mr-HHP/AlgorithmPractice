package huaweiod;

/**
 * @author Mr.黄
 * @date 2022/04/23
 **/
public class HuaWeiOd2 {
    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]
     * 输出：6
     * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
     * 示例 2：
     * 输入：grid = [[0,0,0,0,0,0,0,0]]
     * 输出：0
     * <p>
     * 提示：
     * •	m == grid.length
     * •	n == grid[i].length
     * •	1 <= m, n <= 50
     * •	grid[i][j] 为 0 或 1
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(grid(new int[][]{{0,0,0,0,0,0,0,0}}));
        System.out.println(grid(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
    
    public static int grid(int[][] array) {
        int m = array.length, n = array[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(search(array, i, j), result);
            }
        }
        return result;
    }
    
    public static int search(int[][] array, int row, int col) {
        if (row < 0 || row >= array.length || col < 0 || col >= array[0].length || array[row][col] == 0) {
            return 0;
        }
        array[row][col] = 0;
        int result = 1;
        result += search(array, row + 1, col);
        result += search(array, row - 1, col);
        result += search(array, row, col + 1);
        result += search(array, row, col - 1);
        return result;
    }
}