package leetcode;

/**
 * 单词搜索
 *
 * @author Mr.黄
 * @date 2022/05/03
 **/
public class Leetcode79 {
    /**
     * 利用回溯法解题
     *
     * @param board 给定的数组
     * @param word  给定的单词
     * @return 是否找到符合条件的单词
     */
    public boolean exist(char[][] board, String word) {
        // 标记数组，为了进行剪枝
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 回溯的核心函数
     *
     * @param board   给定的数组
     * @param visited 标记数组，为了进行剪枝
     * @param row     行
     * @param col     列
     * @param word    给定的单词
     * @param index   当前查找单词到的单词下标
     * @return 当前字符是否符合条件
     */
    private boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        if (board[row][col] != word.charAt(index)) {
            // 当前位置的字符不等于目标字符
            return false;
        } else if (index == word.length() - 1) {
            // 已经查找到了目标单词的最后一个字符
            return true;
        }
        // 进行剪枝标记
        visited[row][col] = true;
        boolean result = false;
        // 上下左右的方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                // 没有越界
                if (!visited[newRow][newCol]) {
                    // 没有剪枝过的
                    if (check(board, visited, newRow, newCol, word, index + 1)) {
                        result = true;
                        break;
                    }
                }
            }
        }
        // 进行剪枝
        visited[row][col] = false;
        return result;
    }
    
}