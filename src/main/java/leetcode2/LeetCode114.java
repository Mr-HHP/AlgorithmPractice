package leetcode2;

import offer.chapter7.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.黄
 * @description 二叉树展开为链表
 * @since 2024/7/7 18:05
 **/
public class LeetCode114 {
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(root, nodes);
        for (int i = 0; i < nodes.size() - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = null;
            node.right = nodes.get(i + 1);
        }
    }

    public void dfs(TreeNode root, List<TreeNode> nodes) {
        if (root != null) {
            nodes.add(root);
            dfs(root.left, nodes);
            dfs(root.right, nodes);
        }
    }
}
