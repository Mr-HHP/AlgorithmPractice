package leetcode2;

import offer.chapter4.ListNode;

/**
 * @author Mr.黄
 * @description 两数相加
 * @since 2024/6/19 0:43
 **/
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carryBit = 0;
        while (node1 != null || node2 != null) {
            int val1 = node1 != null ? node1.val : 0;
            int val2 = node2 != null ? node2.val : 0;
            int mod = (val1 + val2 + carryBit) % 10;
            carryBit = (val1 + val2 + carryBit) / 10;
            node.next = new ListNode(mod);
            node = node.next;
            node1 = node1 != null ? node1.next : node1;
            node2 = node2 != null ? node2.next : node2;
        }
        if (carryBit > 0) {
            node.next = new ListNode(carryBit);
        }
        return result.next;
    }

    public static void main(String[] args) {
        System.out.println((9 + 9) % 10);
        System.out.println((9 + 9) / 10);
        System.out.println((5 + 9) % 10);
        System.out.println((5 + 9) / 10);
        System.out.println((1 + 9) % 10);
        System.out.println((1 + 9) / 10);
        System.out.println((1 + 1) % 10);
        System.out.println((1 + 1) / 10);
    }
}
