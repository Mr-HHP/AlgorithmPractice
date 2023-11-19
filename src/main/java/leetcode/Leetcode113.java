package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class Leetcode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, targetSum, path, paths);
        return paths;
    }

    public void dfs(TreeNode treeNode, int targetSum, Deque<Integer> path, List<List<Integer>> paths) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null && targetSum == treeNode.val) {
            path.offerLast(treeNode.val);
            paths.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        path.offerLast(treeNode.val);
        dfs(treeNode.left, targetSum - treeNode.val, path, paths);
        dfs(treeNode.right, targetSum - treeNode.val, path, paths);
        path.removeLast();
    }
}