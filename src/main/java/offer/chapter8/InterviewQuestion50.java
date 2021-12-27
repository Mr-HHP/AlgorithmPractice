package offer.chapter8;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题50：向下的路径节点值之和
 * <p>
 * 给定一棵二叉树和一个值sum，求二叉树中节点值之和等于sum的路径的数目。
 * 路径的定义伟二叉树中顺着指向子节点的指针向下移动所经过的节点，但不一定从根节点开始，也不一定到叶节点结束。
 *
 * @author Mr.黄
 * @date 2021/12/27
 **/
public class InterviewQuestion50 {
  /**
   * 利用二叉树的前序遍历解题
   *
   * @param root 根节点
   * @param sum  给定的sum值
   * @return 返回二叉树中节点值之和等于sum的路径的数目
   */
  public int pathSum(TreeNode root, int sum) {
    // 辅助哈希表，键是累加的节点值之和，值是每个节点值之和出现的次数
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0, 1);
    return dfs(root, sum, map, 0);
  }
  
  /**
   * 核心逻辑，利用二叉树的前序遍历
   *
   * 二叉树前序遍历：根左右
   *
   * @param root 根节点
   * @param sum  给定的sum值
   * @param map  辅助哈希表，键是累加的节点值之和，值是每个节点值之和出现的次数
   * @param path 表示从根节点开始的路径已经累加的节点值之和
   * @return 路径值之和等于sum值的数目
   */
  private int dfs(TreeNode root, int sum, Map<Integer, Integer> map, int path) {
    if (root == null) {
      return 0;
    }
    // 路径上的节点值之和
    path += root.val;
    // 路径上节点值之和等于sum的数目
    // 这里巧妙的利用了差值来求数目，如果差值出现过，那么说明一定有一条路径的节点值之和等于sum
    int count = map.getOrDefault(path - sum, 0);
    // 如果这个节点值之和之前出现过，则将出现的次数加1；如果没出现过，那么这是它的第一次出现
    map.put(path, map.getOrDefault(path, 0) + 1);
    // 递归处理子节点
    count += dfs(root.left, sum, map, path);
    count += dfs(root.right, sum, map, path);
    
    // 递归结束了，返回的上一层就是当前节点的父节点。
    // 返回上一层之前需要把当前节点从path中删除，因为父节点那一层级的path中还没有累加到这里
    map.put(path, map.get(path) - 1);
    return count;
  }
}