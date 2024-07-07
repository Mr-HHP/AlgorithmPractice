package leetcode2;

import offer.chapter7.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.黄
 * @description 二叉搜索树中第K小的元素
 * @since 2024/7/7 16:04
 **/
public class LeetCode230 {
    int count = 0;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        dfs(root, nodes);
        return nodes.get(k - 1);
    }

    // 解法一：中序遍历，需要缓存整个树的节点再获取下标k-1的值
    public void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right, nodes);
        }
    }

    // 解法二：中序遍历，不需要缓存整棵树
    public void dfs2(TreeNode root, int k) {
        if (root != null) {
            dfs2(root.left, k);
            count++;
            if (count == k) {
                result = root.val;
                return;
            }
            dfs2(root.right, k);
        }
    }
}
