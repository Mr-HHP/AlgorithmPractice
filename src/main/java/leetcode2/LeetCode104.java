package leetcode2;

import offer.chapter7.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mr.黄
 * @description 二叉树的最大深度
 * @since 2024/6/23 14:13
 **/
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
