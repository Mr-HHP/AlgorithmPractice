package leetcode;

import offer.chapter7.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author Mr.黄
 * @date 2022/05/05
 **/
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean reverse = false;
        if (root != null) {
            currentQueue.offer(root);
        }
        while (!currentQueue.isEmpty()) {
            TreeNode node = currentQueue.poll();
            temp.add(node.val);
            if (node.left != null) {
                nextQueue.offer(node.left);
            }
            if (node.right != null) {
                nextQueue.offer(node.right);
            }
            if (currentQueue.isEmpty()) {
                if (reverse) {
                    Collections.reverse(temp);
                    reverse = false;
                } else {
                    reverse = true;
                }
                result.add(temp);
                temp = new ArrayList<>();
                currentQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(list.addAll(new ArrayList<>(stack)));
        for (int i : list) {
            System.out.println(i);
        }
        System.out.println("++++++++++++");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        
    }
}