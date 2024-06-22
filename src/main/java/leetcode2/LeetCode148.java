package leetcode2;

import offer.chapter4.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mr.黄
 * @description 排序链表
 * @since 2024/6/22 16:21
 **/
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy.next;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (current != null) {
            treeMap.put(current.val, treeMap.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }
        current = dummy.next;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                current.val = key;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
