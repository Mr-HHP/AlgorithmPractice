package offer.chapter8;

import java.util.Stack;

/**
 * 面试题55：二叉搜索树迭代器
 *
 * 请实现二叉搜索树的迭代器BSTIterator，它主要有如下3个函数
 *   构造函数：输出二叉搜索树的根节点初始化该迭代器
 *   函数next：返回二叉搜索树中下一个最小的节点的值
 *   函数hasNext：返回二叉搜索树是否还有下一个节点
 *
 * @author Mr.黄
 * @date 2022/01/04
 **/
public class InterviewQuestion55 {
  /**
   * 二叉搜索树迭代器
   *
   * 利用二叉树的中序遍历实现
   *
   * 空间复杂度：O(h)，h为二叉搜索树的深度
   *
   */
  public class BSTIterator {
    TreeNode cur;
    Stack<TreeNode> stack;
  
    /**
     * 初始化迭代器
     *
     * @param root 二叉搜索树根节点
     */
    public BSTIterator(TreeNode root) {
      cur = root;
      stack = new Stack<>();
    }
  
    /**
     * 返回二叉搜索树是否还有下一个节点
     *
     * 时间复杂度：O(1)
     *
     * @return 有下一个节点返回true，否则返回false
     */
    public boolean hasNext() {
      return cur != null || !stack.isEmpty();
    }
  
    /**
     * 返回二叉搜索树中下一个最小的节点的值
     *
     * 平均时间复杂度：O(1)
     *
     * @return 下一个最小的节点的值
     */
    public int next() {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      int val = cur.val;
      cur = cur.right;
      return val;
    }
  }
}