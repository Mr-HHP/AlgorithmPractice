package leetcode;

import offer.chapter4.ListNode;

/**
 * 相交链表
 *
 * @author Mr.黄
 * @date 2022/04/04
 **/
public class Leetcode166 {
    /**
     * 利用双指针解题
     *
     * 算法公式：a+(b-c)=b+(a-c)
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}