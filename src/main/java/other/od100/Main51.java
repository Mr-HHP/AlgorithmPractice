package other.od100;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 生成哈夫曼树
 * @since 2024/7/23 23:07
 **/
public class Main51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Node51> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(new Node51(scanner.nextInt(), 0));
        }
        while (minHeap.size() > 1) {
            Node51 node1 = minHeap.poll();
            Node51 node2 = minHeap.poll();
            Node51 node3 = new Node51(node1.value + node2.value, node1.height + 1);
            node3.left = node1;
            node3.right = node2;
            minHeap.add(node3);
        }
        dfs(minHeap.poll());

    }

    public static void dfs(Node51 root) {
        if (root.left != null && root.right != null) {
            if (root.left.value > root.right.value) {
                Node51 temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }
        if (root.left != null) {
            dfs(root.left);
        }
        System.out.print(root.value + " ");
        if (root.right != null) {
            dfs(root.right);
        }
    }
}

class Node51 implements Comparable<Node51> {
    int value;
    int height;
    Node51 left;
    Node51 right;
    public Node51(int value, int height) {
        this.value = value;
        this.height = height;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node51 o) {
        if (this.value == o.value) {
            return this.height = o.height;
        }
        return this.value - o.value;
    }
}
