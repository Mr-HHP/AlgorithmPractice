package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 删除链表倒数第N个节点
 * @since 2024/6/20 0:06
 **/
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode leftNode = dummy;
        ListNode rightNode = head;
        while (n != 0) {
            rightNode = rightNode.next;
            n--;
        }
        while (rightNode != null) {
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        leftNode.next = leftNode.next.next;
        return dummy.next;
    }
}
