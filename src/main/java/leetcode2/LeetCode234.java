package leetcode2;

import offer.chapter4.ListNode;

import java.util.Stack;

/**
 * @author Mr.黄
 * @description 回文链表
 * @since 2024/6/16 17:40
 **/
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode left = head;
        while (!stack.isEmpty()) {
            ListNode right = stack.pop();
            if (right.val != left.val) {
                return false;
            }
            left = left.next;
        }
        return true;
    }
}
