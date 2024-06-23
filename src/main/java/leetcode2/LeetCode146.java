package leetcode2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.黄
 * @description LUR最近最少使用缓存
 * @since 2024/6/22 19:29
 **/
public class LeetCode146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 0);  // {1=0}
        lruCache.put(2, 2);  // {1=0, 2=2}
        System.out.println(lruCache.get(1));  // 0  {2=2, 1=0}
        lruCache.put(3, 3);  // {1=0, 3=3}
        System.out.println(lruCache.get(2));  // -1
        lruCache.put(4, 4);  // {3=3, 4=4}
        System.out.println(lruCache.get(1));  // -1   0
        System.out.println(lruCache.get(3));  // 3
        System.out.println(lruCache.get(4));  // 4
    }
}

class LRUCache {
    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.perv = head;
    }

    public int get(int key) {
        ListNode listNode = map.get(key);
        if (listNode == null) {
            return -1;
        }
        moveToTali(listNode);
        return listNode.value;
    }

    public void moveToTali(ListNode listNode) {
        ListNode perv = listNode.perv;
        ListNode next = listNode.next;
        perv.next = next;
        next.perv = perv;

        tail.perv.next = listNode;
        listNode.perv = tail.perv;
        listNode.next = tail;
        tail.perv = listNode;
    }

    public void put(int key, int value) {
        ListNode listNode = map.get(key);
        if (listNode == null) {
            listNode = new ListNode(key,value);
            if (map.size() == capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.perv = head;
            }
            map.put(key, listNode);
            tail.perv.next = listNode;
            listNode.perv = tail.perv;
            listNode.next = tail;
            tail.perv = listNode;
        } else {
            listNode.value = value;
            moveToTali(listNode);
        }
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode perv;
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
