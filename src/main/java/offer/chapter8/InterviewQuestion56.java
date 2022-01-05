package offer.chapter8;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 面试题56：二叉搜索树中两个节点值之和
 *
 * 给定一棵二叉搜索树和一个值k，请判断该二叉搜索树中是否存在值之和等于k的两个节点。
 * 假设二叉搜索树中节点的值均唯一。
 *
 * @author Mr.黄
 * @date 2022/01/05
 **/
public class InterviewQuestion56 {
  /**
   * 利用哈希表，空间复杂度为O(n)的解法
   *   利用哈希表保存节点的值。
   *   每遍历到一个节点（节点值记为v），就在哈希表中查看是否存在值为k-v的节点
   *   该算法使用任何二叉树，并没有利用二叉搜索树的特性
   *
   * 空间复杂度：O(n)
   *
   * @param root 二叉搜索树根节点
   * @param k 给定的节点k
   * @return 存在两个节点值之和等于k返回true，否则返回false
   */
  public boolean findTarget1(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (set.contains(k - cur.val)) {
        return true;
      }
      set.add(cur.val);
      cur = cur.right;
    }
    return false;
  }
  
  /**
   * 应用双指针，空间复杂度为O(h)的解法
   *   递增序列中
   *   第1个指针指向数组中的第一个（也是最小的一个），第2个指针指向数组最后一个（也是最大的）。
   *   如果两个数字之和等于k，那么结束查找；
   *   如果两个数字之和大于k，那么向左移动第2个指针使它指向更小的数字；
   *   如果两个数字之和小于k，那么向右移动第1个指针使它指向更大的数字。
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(h)，h是二叉搜索树的深度
   *
   * @param root 二叉树搜索树根节点
   * @param k 给定的k
   * @return 存在两个节点之和等于k返回true，否则返回false
   */
  public boolean findTarget2(TreeNode root, int k) {
    if (root == null) {
      return false;
    }
    BSTIterator iterNex = new BSTIterator(root);
    BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);
    int next = iterNex.next();
    int prev = iterPrev.prev();
    while (next != prev) {
      if (next + prev == k) {
        return true;
      }
      if (next + prev < k) {
        next = iterNex.next();
      } else {
        prev = iterPrev.prev();
      }
    }
    return false;
  }
  
  /**
   * 二叉搜索迭代器
   * 为了从递增序列中从小到大去除下一个节点
   */
  public class BSTIterator {
    TreeNode cur;
    Stack<TreeNode> stack;
  
    /**
     * 输入二叉搜索树的根节点，初始化迭代器
     * @param root 二叉搜索树的根节点
     */
    public BSTIterator(TreeNode root) {
      cur = root;
      stack = new Stack<>();
    }
  
    /**
     * 返回二叉搜索树是否还有下一个节点
     *
     * @return 有下一个节点返回true，否则返回false
     */
    public boolean hasNext() {
      return cur != null || !stack.isEmpty();
    }
  
    /**
     * 返回二叉搜索树中下一个最小的节点的值
     *
     * @return 二叉搜索树中下一个最小节点的值
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
  
  /**
   * 二叉搜索树迭代器（颠倒顺序）
   * 为了从大到小取出下一个节点
   */
  public class BSTIteratorReversed {
    TreeNode cur;
    Stack<TreeNode> stack;
  
    /**
     * 输入二叉搜索树根节点，初始化迭代器
     * @param root 二叉搜索树根节点
     */
    public BSTIteratorReversed(TreeNode root) {
      cur = root;
      stack = new Stack<>();
    }
  
    /**
     * 返回二叉搜索树是否还有上一个节点
     *
     * @return 有上一个节点放回true，否则返回false
     */
    public boolean hasPrev() {
      return cur != null || !stack.isEmpty();
    }
  
    /**
     * 返回二叉搜索树中上一个最大的节点的值
     *
     * @return 二叉搜索树中上一个最大的节点的值
     */
    public int prev() {
      while (cur != null) {
        stack.push(cur);
        cur = cur.right;
      }
      cur = stack.pop();
      int val = cur.val;
      cur = cur.left;
      return val;
    }
  }
}