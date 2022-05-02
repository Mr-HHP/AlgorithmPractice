package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * @author Mr.黄
 * @date 2022/05/02
 **/
public class Leetcode78 {
    /**
     * 利用回溯法解题
     *
     * @param nums 给定数组
     * @return 返回子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        helper(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }
    
    /**
     * 回溯法的核心函数
     *
     * @param nums   给定的数组
     * @param index  取出数字在给定数组的下标
     * @param subset 当前子集
     * @param result 结果子集
     */
    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            // 注意，返回的是subset的副本，并不是直接返回subset本身，因为接下来还需要对subset进行操作
            result.add(new LinkedList<>(subset));
        } else if (index < nums.length) {
            // 首先考虑不将该数字添加到子集的情况
            helper(nums, index + 1, subset, result);
            // 考虑将该数字添加到子集的情况
            subset.add(nums[index]);
            helper(nums, index + 1, subset, result);
            // 回溯到上一步操作（父节点）前需要清除已经对子集状态的修改操作
            subset.removeLast();
        }
    }
}