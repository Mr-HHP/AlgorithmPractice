package offer.chapter8;

import java.util.Stack;

/**
 * 面试题52：展平二叉搜索树
 *
 * 给定一棵二叉搜索树，请调整节点的指针使每个节点都没有左子节点。
 * 调整之后的树看起来像是一个链表，但仍然是二叉搜索树。
 *
 * @author Mr.黄
 * @date 2021/12/31
 **/
public class InterviewQuestion52 {
  /**
   * 利用二叉树的中序遍历的迭代方式解题
   * 二叉树中序遍历：左根右
   * 二叉树的中序遍历迭代方式需要利用辅助栈
   *
   * @param root 二叉树根节点
   * @return
   */
  public TreeNode increasingBST(TreeNode root) {
    // 辅助栈
    Stack<TreeNode> stack = new Stack<>();
    // 当前节点
    TreeNode cur = root;
    // 上一个节点
    TreeNode prev = null;
    // 展平后的第一个节点
    TreeNode first = null;
    while (cur != null && !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (prev != null) {
        // 上一个节点非空
        prev.right = cur;
      } else {
        // 二叉树展平后的根节点；中序遍历第一个遍历的节点
        first = cur;
      }
      prev = cur;
      cur.left = null;
      cur = cur.right;
    }
    return first;
  }
}