package leetcode2;

import offer.chapter4.ListNode;

import java.util.Stack;

/**
 * @author Mr.黄
 * @description 反转链表
 * @since 2024/6/16 16:35
 **/
public class LeetCode206 {
    // [1,2,3,4,5]
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
