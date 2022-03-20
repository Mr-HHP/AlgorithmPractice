package leetcode;

import offer.chapter4.ListNode;


/**
 * 删除链表的倒数第n个节点
 *
 * @author Mr.黄
 * @date 2022/03/20
 **/
public class Leetcode19 {
    /**
     * 使用前后双指针解题
     *
     * @param head 给定的链表
     * @param n    倒数第n个节点
     * @return 删除倒数第n个几点后的链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用辅助节点处理删除头节点的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}