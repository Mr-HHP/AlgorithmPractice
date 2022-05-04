package leetcode;

import offer.chapter7.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author Mr.黄
 * @date 2022/05/04
 **/
public class Leetcode102 {
    /**
     * 使用双队列进行解题
     *
     * @param root 根节点
     * @return 二叉树的层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            currentQueue.offer(root);
        }
        List<Integer> levelList = new ArrayList<>();
        while (!currentQueue.isEmpty()) {
            TreeNode node = currentQueue.poll();
            levelList.add(node.val);
            if (node.left != null) {
                nextQueue.offer(node.left);
            }
            if (node.right != null) {
                nextQueue.offer(node.right);
            }
            if (currentQueue.isEmpty()) {
                result.add(levelList);
                levelList = new ArrayList<>();
                currentQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        return result;
    }
}