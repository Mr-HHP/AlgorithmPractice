package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 环形链表2
 * @since 2024/6/16 19:39
 **/
public class LeetCode142 {

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    // [3,2,0,4]
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                break;
            }
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (fast == null) {
            return null;
        }
        ListNode node = head;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return node;
    }

    public static void main(String[] args) {
        LeetCode142 leetCode142 = new LeetCode142();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        leetCode142.detectCycle(head);
//        leetCode142.detectCycle2(head);
    }
}
