package leetcode2;

import offer.chapter7.TreeNode;

import java.util.*;

/**
 * @author Mr.黄
 * @description 二叉树的右视图
 * @since 2024/7/7 16:51
 **/
public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 1 && !queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            TreeNode lastNode = queue.poll();
            if (lastNode.left != null) {
                queue.offer(lastNode.left);
            }
            if (lastNode.right != null) {
                queue.offer(lastNode.right);
            }
            result.add(lastNode.val);
        }
        return result;
    }
}
