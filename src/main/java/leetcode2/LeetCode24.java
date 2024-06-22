package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 两两交换链表中的节点
 * @since 2024/6/20 0:55
 **/
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            ListNode node1 = node.next;
            ListNode node2 = node.next.next;
            node.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            node = node1;
        }
        return dummy.next;
    }
}
