package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 合并两个有序链表
 * @since 2024/6/19 0:15
 **/
public class LeetCode21 {
    // list1 [1,2,4]
    // list2 [1,3,4]
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return result.next;
    }
}
