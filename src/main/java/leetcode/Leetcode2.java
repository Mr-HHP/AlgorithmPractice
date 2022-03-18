package leetcode;

import offer.chapter4.ListNode;

/**
 * 两数之和相加
 *
 * @author Mr.黄
 * @date 2022/03/18
 **/
public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // 利用哨兵节点简化链表插入操作
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        // 进位
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head2 == null ? 0 : head2.val) + (head1 == null ? 0 : head1.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            sumNode.next = new ListNode(sum);
            sumNode = sumNode.next;
            head2 = head2 == null ? null : head2.next;
            head1 = head1 == null ? null : head1.next;
        }
        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
    }
}