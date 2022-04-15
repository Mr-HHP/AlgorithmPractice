package leetcode;

import offer.chapter4.ListNode;

/**
 * 回文链表
 *
 * @author Mr.黄
 * @date 2022/04/16
 **/
public class Leetcode234 {
    /**
     * 利用快慢指针法解题
     *
     * @param head 头节点
     * @return 是回文链表true，否则false
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        if (fast.next != null) {
            secondHalf = slow.next.next;
        }
        slow.next = null;
        return equals(secondHalf, reverseList(head));
    }
    
    /**
     * 链表反转
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    /**
     * 比较两条链表是否相等
     *
     * @param firstHalf 链表1
     * @param secondHalf 链表2
     * @return 相等胃true，否则false
     */
    private boolean equals(ListNode firstHalf, ListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return firstHalf == null && secondHalf == null;
    }
}