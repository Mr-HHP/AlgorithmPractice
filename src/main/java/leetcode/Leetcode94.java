package leetcode;

import offer.chapter4.Node;
import offer.chapter7.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author Mr.黄
 * @date 2022/03/22
 **/
public class Leetcode94 {
    /**
     * 二叉树的中序遍历（递归实现）
     *
     * @param root 树的根节点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }
    
    /**
     * 中序遍历（左根右）
     *
     * @param root 树的根节点
     * @param nodes 节点列表
     */
    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            // 左根右
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right, nodes);
        }
    }
}