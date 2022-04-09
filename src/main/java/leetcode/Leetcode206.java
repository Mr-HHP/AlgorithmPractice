package leetcode;

import offer.chapter4.ListNode;

/**
 * 反转链表
 *
 * @author Mr.黄
 * @date 2022/04/09
 **/
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = next;
        }
        return preNode;
    }
}