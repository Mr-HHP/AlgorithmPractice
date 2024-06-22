package leetcode2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.黄
 * @description 随机链表的复制
 * @since 2024/6/22 15:59
 **/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class LeetCode138 {
    public Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> map = new HashMap<>();
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node node = map.get(current);
            Node next = map.get(current.next);
            Node random = map.get(current.random);
            node.next = next;
            node.random = random;
            current = current.next;
        }
        return map.get(head);
    }
}
