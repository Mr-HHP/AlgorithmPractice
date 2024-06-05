package offer;

import offer.chapter4.ListNode;

/**
 *
 * @description 反转链表
 * @author Mr.黄
 * @since 2023/12/10
*/
public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode prev = null;
        ListNode cur = listNode;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }


}
