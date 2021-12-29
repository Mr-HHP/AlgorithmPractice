package offer.chapter8;

/**
 * 面试题51：节点值之和最大的路径
 *
 * 在二叉树中将路径定义为顺则会节点之间的连接从任意一个节点开始到达任意一个节点所经过的所有节点。
 * 路径中至少包含一个节点，不一定经过二叉树的根节点，也不一定经过叶节点。
 * 给定非空的一棵二叉树，请求出二叉树所有路径上节点值之和的最大值
 *
 * @author Mr.黄
 * @date 2021/12/29
 **/
public class InterviewQuestion51 {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(-9);
    root.left = new TreeNode(4);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.left.left = new TreeNode(-3);
    root.right.right = new TreeNode(7);
    System.out.println(maxPathSum(root));
  }
  
  /**
   * 利用二叉树的后序遍历解题
   * 后序遍历：左右根
   *
   * 解题思路：
   *   当路径到达某个节点时，该路径既可以前往它的左子树，也可以前往它的右子树。
   *   但是如果同时经过它的左右子树，那么就不能经过它的父节点。
   *   所以路径有三种情况：
   *     1、当前节点路径只经过左子树
   *     2、当前节点路径只经过右子树
   *     3、当前节点路径同时经过左右子树
   *   对三种情况求最大值，然后进行三者比较
   *
   * @param root 二叉树根节点
   * @return 节点值之和最大的路径
   */
  public static int maxPathSum(TreeNode root) {
    int[] maxSum = {Integer.MAX_VALUE};
    dfs(root, maxSum);
    return maxSum[0];
  }
  
  /**
   * 计算的核心逻辑（利用二叉树递归后序遍历）
   *
   * @param root 根节点
   * @param maxSum 最大值
   * @return 经过当前节点并前往其左子树或右子树的路径的节点值之和的最大值
   */
  private static int dfs(TreeNode root, int[] maxSum) {
    if (root == null) {
      return 0;
    }
    // 当前节点的左子树的节点值之和最大值的路径
    int[] maxSumLeft = {Integer.MAX_VALUE};
    int left = Math.max(0, dfs(root.left, maxSumLeft));
    // 当前节点的右子树的节点值之和的最大值的路径
    int[] maxSumRight = {Integer.MAX_VALUE};
    int right = Math.max(0, dfs(root.right, maxSumRight));
    // 左边的最大时、右边的最大值、经过当前节点的路径的最大值；三者进行比较取最大值
    maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);
    maxSum[0] = Math.max(maxSum[0], root.val + left + right);
    return root.val + Math.max(left, right);
  }
}