package leetcode;

import offer.chapter7.TreeNode;

/**
 * 验证二叉搜索树
 *
 * @author Mr.黄
 * @date 2022/05/04
 **/
public class Leetcode98 {
    /**
     * 利用二叉搜索树的特性解题，使用中序遍历
     *
     * @param root 给定根节点
     * @return 是否是二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    /**
     * 中序遍历核心逻辑
     *
     * @param node  节点
     * @param lower 上一个节点
     * @param upper 下一个节点
     * @return 是否符合二叉搜索树
     */
    private boolean dfs(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        // 访问左子树
        if (!dfs(node.left, lower, node.val)) {
            return false;
        }
        // 访问当前节点，如果i当前节点小于等于前一个节点或者大于等于下一个节点，则不是二叉搜索树；否则继续遍历右子树
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 访问右子树
        return dfs(node.right, node.val, upper);
    }
    
}