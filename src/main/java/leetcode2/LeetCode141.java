package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 环形链表
 * @since 2024/6/16 18:00
 **/
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
            if (fast != null) {
                fast = fast.next;
            }
        }
        return false;
    }
}
