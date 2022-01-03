package offer.chapter8;

import java.util.Stack;

/**
 * 面试题54：所有大于或等于节点的值之和
 *
 * 给定一棵二叉搜索树，请将它的每个节点的值替换成树中大于或等于该节点值的所有节点值之和。
 * 假设二叉搜索树中节点的值唯一。
 *
 * @author Mr.黄
 * @date 2022/01/02
 **/
public class InterviewQuestion54 {
  /**
   * 利用颠倒的二叉树中序遍历解题，使用一次遍历即可解题
   * 因为遍历到一个节点之前值大于该节点的值的所有节点已经遍历过
   *
   * 颠倒的中序遍历：右根左
   *
   *
   * @param root 二叉树根节点
   * @return 二叉树节点
   */
  public TreeNode convertBST(TreeNode root) {
    // 辅助栈（中序遍历迭代方式需要使用辅助栈）
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    int sum = 0;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.right;
      }
      cur = stack.pop();
      sum += cur.val;
      cur.val = sum;
      cur = cur.left;
    }
    return root;
  }
}