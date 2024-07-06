package leetcode2;

import offer.chapter7.TreeNode;

/**
 * @author Mr.黄
 * @description 翻转二叉树
 * @since 2024/7/5 17:59
 **/
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
