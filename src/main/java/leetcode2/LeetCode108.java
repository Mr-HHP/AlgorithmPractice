package leetcode2;

import offer.chapter7.TreeNode;

/**
 * @author Mr.黄
 * @description 将有序数组转换为二叉搜索树
 * @since 2024/7/6 17:01
 **/
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftTree = build(nums, left, mid - 1);
        TreeNode rightTree = build(nums, mid + 1, right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
