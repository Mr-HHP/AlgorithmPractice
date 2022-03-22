package leetcode;

import offer.chapter7.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @author Mr.黄
 * @date 2022/03/22
 **/
public class Leetcode101 {
    
    /**
     * 递归法解题
     *
     * @param root 二叉树根节点
     * @return 返回结果
     */
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }
    
    public boolean check1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
    
    /**
     * 迭代法解题
     *
     * @param root 二叉树根节点
     * @return 返回结果
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            
            q.offer(u.left);
            q.offer(v.right);
            
            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}