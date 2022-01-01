package offer.chapter8;

import java.util.Stack;

/**
 * 面试题53：二叉搜索树的下一个节点
 *
 * 给定一棵二叉搜索树和它的一个节点p，请找出按中序遍历的顺序该节点p的下一个节点。
 * 假设二叉搜索树中节点的值都是唯一的。
 *
 * @author Mr.黄
 * @date 2022/01/02
 **/
public class InterviewQuestion53 {
  /**
   * 时间复杂度O(n)的解法
   *
   * 采用常规的二叉树的迭代方式的中序遍历解题（需要辅助栈）
   * 中序遍历：左根右
   *
   * 利用一个布尔变量found来记录已经遍历到的节点p
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(h)，h为二叉树的深度
   *
   * @param root 二叉树根节点
   * @param p 给定的二叉树p节点
   * @return 按照中序遍历的顺序节点p的下一个节点
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    // 辅助栈
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    // 辅助变量found
    boolean found = false;
    // 中序遍历迭代方式核心逻辑
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (found) {
        break;
      } else if (p == cur) {
        found = true;
      }
      cur = cur.right;
    }
    return cur;
  }
  
  /**
   * 时间复杂度O(h)的解法
   * 换一个角度解题
   *   如果当前节点小于等于p，那么p的下一个节点应该在当前节点的右子树
   *   如果当前节点大于p，那么p的下一个节点应该在当前节点的左子树，或者可能就是当前节点
   *     记录下当前节点，在寻找当前节点的左子树，寻找到最小的那个左节点
   *
   * 时间复杂度：O(h)，h是二叉树的深度
   * 空间复杂度：O(1)
   *
   * @param root 二叉树根节点
   * @param p 给定的节点
   * @return 按照中序遍历的顺序节点p的下一个节点
   */
  public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
    TreeNode cur = root;
    TreeNode result = null;
    while (cur != null) {
      if (cur.val > p.val) {
        result = cur;
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    return result;
  }
}