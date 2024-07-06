package leetcode2;

import offer.chapter7.TreeNode;

/**
 * @author Mr.黄
 * @description 对称二叉树
 * @since 2024/7/5 18:15
 **/
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return subIsSymmetric(root.left, root.right);
    }

    public boolean subIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean valSymmetric = left.val == right.val;
        boolean subIsSymmetric1 = subIsSymmetric(left.left, right.right);
        boolean subIsSymmetric2 = subIsSymmetric(left.right, right.left);
        return valSymmetric && subIsSymmetric1 && subIsSymmetric2;
    }
}
