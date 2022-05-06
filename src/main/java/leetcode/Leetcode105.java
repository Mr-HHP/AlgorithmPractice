package leetcode;

import offer.chapter7.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author Mr.黄
 * @date 2022/05/06
 **/
public class Leetcode105 {
    /**
     * 利用分治的思想解题
     * 递归的生成左子树和右子树，把大问题化成小问题
     *
     * @param preorder 前序遍历序列
     * @param inorder  中序遍历序列
     * @return 完整的二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    /**
     * @param perorder 前序遍历序列
     * @param pStart   前序遍历左右子树的开始位置
     * @param pEnd     前序遍历左右子树的结束位置
     * @param inorder  中序遍历的学列
     * @param iStart   中序遍历左右子树的开始位置
     * @param iEnd     中序遍历左右子树的结束位置
     * @return 构造好的二叉树
     */
    private TreeNode buildTreeHelper(int[] perorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // 前序遍历为空，直接返回null
        if (pStart == pEnd) {
            return null;
        }
        int rootVal = perorder[pStart];
        TreeNode rootNode = new TreeNode(rootVal);
        // 在中序遍历种找到根节点的位置
        int iRootIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (rootVal == inorder[i]) {
                iRootIndex = i;
                break;
            }
        }
        // 左子树的数量
        int leftNum = iRootIndex - iStart;
        // 递归的构造左子树
        rootNode.left = buildTreeHelper(perorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRootIndex);
        // 递归的构造右子树
        rootNode.right = buildTreeHelper(perorder, pStart + leftNum + 1, pEnd, inorder, iRootIndex + 1, iEnd);
        return rootNode;
    }
}