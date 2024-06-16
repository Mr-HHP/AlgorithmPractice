package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 相交链表
 * @since 2024/6/16 15:15
 **/
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = countNode(headA);
        int bLength = countNode(headB);
        int diff = Math.abs(aLength - bLength);
        ListNode longer = aLength > bLength ? headA : headB;
        ListNode shorter = aLength > bLength ? headB : headA;
        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }

    public int countNode(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
