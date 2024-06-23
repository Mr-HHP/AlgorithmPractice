package leetcode2;

import offer.chapter7.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.黄
 * @description 二叉树的中序遍历
 * @since 2024/6/23 13:55
 **/
public class LeetCode94 {
    // 中序遍历：左根右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    public void dfs(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs(list, treeNode.left);
        list.add(treeNode.val);
        dfs(list, treeNode.right);
    }
}
