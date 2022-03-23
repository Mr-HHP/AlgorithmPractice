package leetcode;

import offer.chapter4.ListNode;

import java.sql.ResultSet;

/**
 * 环形链表
 *
 * @author Mr.黄
 * @date 2022/03/24
 **/
public class Leetcode141 {
    /**
     * 快慢指针发解题
     *
     * @param head 链表头节点
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}