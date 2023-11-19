package leetcode;

public class Leetcode112 {
    int pathSum = 0;
    boolean hasPathSum = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return hasPathSum;
    }

    public void dfs(TreeNode treeNode, int targetSum) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null && targetSum == pathSum + treeNode.val) {
            hasPathSum = true;
            return;
        }
        pathSum += treeNode.val;
        dfs(treeNode.left, targetSum);
        dfs(treeNode.right, targetSum);
        pathSum -= treeNode.val;
    }
}
