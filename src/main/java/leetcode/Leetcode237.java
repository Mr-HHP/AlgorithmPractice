package leetcode;

import offer.chapter4.ListNode;

/**
 * 删除链表中的节点
 *
 * @author Mr.黄
 * @date 2022/04/19
 **/
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}