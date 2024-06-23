package leetcode2;

import offer.chapter4.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Mr.黄
 * @description 合并k个升序链表
 * @since 2024/6/22 18:07
 **/
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            ListNode current = listNode;
            while (current != null) {
                list.add(current.val);
                current = current.next;
            }
        }
        if (list.size() == 0) {
            return null;
        }
        Collections.sort(list);
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head;
    }
}
