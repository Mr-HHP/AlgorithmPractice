package leetcode2;

import offer.chapter7.TreeNode;

/**
 * @author Mr.黄
 * @description 二叉树的直径
 * @since 2024/7/6 13:56
 **/
public class LeetCode543 {
    int result = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        subTreeDiameter(root);
        return result - 1;
    }

    public int subTreeDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = subTreeDiameter(root.left);
        int rightDiameter = subTreeDiameter(root.right);
        result = Math.max(result, leftDiameter + rightDiameter + 1);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
