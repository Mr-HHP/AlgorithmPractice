package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 旋转链表
 * @since 2024/7/5 16:24
 **/
public class LeetCode61 {
    // [1,2,3,4,5]
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy.next;
        ListNode pre = dummy;
        int count = 0;
        while (current != null) {
            count++;
            pre = current;
            current = current.next;
        }
        if (count == 0 || count == k || count == 1) {
            return head;
        }
        int mod = k;
        if (k > count) {
            mod = k % count;
        }
        if (mod == 0) {
            return head;
        }
        int diff = count - mod;
        ListNode leftEnd = dummy;
        for (int i = 0; i < diff; i++) {
            leftEnd = leftEnd.next;
        }
        ListNode rightHead = leftEnd.next;
        ListNode rightEnd = pre;

        dummy.next = rightHead;
        rightEnd.next = head;
        leftEnd.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(99 % 1);
    }
}
