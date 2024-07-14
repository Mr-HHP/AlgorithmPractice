package leetcode2;

import offer.chapter7.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.黄
 * @description 从前序与中序遍历序列构造二叉树
 * @since 2024/7/8 0:01
 **/
public class LeetCode105 {
    Map<Integer, Integer> map;

    // preorder: [3,9,20,15,7]
    // inorder: [9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0);
    }

    // [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    // [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
    public TreeNode build(int[] preorder, int preorderLeft, int preorderRight, int inLeft) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int rootValue = preorder[preorderLeft];
        TreeNode root = new TreeNode(rootValue);
        Integer rootIndex = map.get(rootValue);
        int leftSize = rootIndex - inLeft;
        root.left = build(preorder, preorderLeft + 1, preorderLeft + leftSize, inLeft);
        root.right = build(preorder, preorderLeft + leftSize + 1, preorderRight, rootIndex + 1);
        return root;
    }
}
