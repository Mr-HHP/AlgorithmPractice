package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description K 个一组翻转链表
 * @since 2024/6/22 11:30
 **/
public class LeetCode25 {
    // [1,2,3,4,5]  => [2,1,4,3,5]
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while (head != null) {
            ListNode end = prev;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }
            ListNode next = end.next;
            ListNode[] reverse = reverse(head, end);
            head = reverse[0];
            end = reverse[1];
            prev.next = head;
            end.next = next;
            prev = end;
            head = end.next;
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode end) {
        ListNode prev = end.next;
        ListNode current = head;
        while (end != prev) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return new ListNode[]{end, head};
    }
}
