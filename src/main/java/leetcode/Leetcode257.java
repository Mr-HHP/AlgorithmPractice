package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    public void dfs(TreeNode treeNode, String path, List<String> paths) {
        if (treeNode != null) {
            if (treeNode.left == null && treeNode.right == null) {
                // 叶子节点
                paths.add(path);
            } else {
                // 非叶子节点
                path = path + treeNode.val + "->";
                dfs(treeNode.left, path, paths);
                dfs(treeNode.right, path, paths);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}