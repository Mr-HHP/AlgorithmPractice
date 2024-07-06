package leetcode2;

import offer.chapter7.TreeNode;

/**
 * @author Mr.黄
 * @description 验证二叉搜索树
 * @since 2024/7/6 17:53
 **/
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        boolean leftValid = dfs(root.left, left, root.val);
        if (!leftValid) {
            return false;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return dfs(root.right, root.val, right);
    }
}
