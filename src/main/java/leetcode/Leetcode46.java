package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 *
 * @author Mr.黄
 * @date 2022/03/25
 **/
public class Leetcode46 {
    /**
     * 回溯法解题
     *
     * @param nums 给定数组
     * @return 结果
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        
        int n = nums.length;
        backtrack(n, output, result, 0);
        return result;
    }
    
    public void backtrack(int n, List<Integer> output, List<List<Integer>> result, int first) {
        // 所有数都填完了
        if (first == n) {
            result.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, result, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}