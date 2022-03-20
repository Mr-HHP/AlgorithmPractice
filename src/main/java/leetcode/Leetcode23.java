package leetcode;

import offer.chapter4.ListNode;

/**
 * 合并k个升序链表
 *
 * @author Mr.黄
 * @date 2022/03/20
 **/
public class Leetcode23 {
    /**
     * 使用分治法解题
     * 用分治的方法进行合并。
     *
     * 将 k 个链表配对并将同一对中的链表合并；
     * 第一轮合并以后， k 个链表被合并成了 k/2 个链表，平均长度为 2n/k，然后是 k/4个链表，k/8 个链表等等；
     * 重复这一过程，直到我们得到了最终的有序链表。
     *
     * @param lists 给定的链表集合
     * @return 合并后的结果链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
    
    /**
     * 合并两个链表的方法
     *
     * @param a 给定的链表a
     * @param b 给定的链表b
     * @return 合并后的结果链表
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}