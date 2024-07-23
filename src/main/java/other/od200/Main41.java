package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 二叉树的广度优先遍历
 * @since 2024/7/22 16:49
 **/
public class Main41 {
    public static String postOrder;
    public static String inOrder;
    public static Map<Character, Integer> inMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        postOrder = scanner.next();
        inOrder = scanner.next();
        int n = postOrder.length();
        for (int i = 0; i < n; i++) {
            inMap.put(inOrder.charAt(i), i);
        }
        Node root = buildTree(0, n - 1, 0, n - 1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static Node buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        Node root = new Node(postOrder.charAt(postEnd));
        if (inStart == inEnd) {
            return root;
        }
        int inRootIndex = inMap.get(root.val);
        int leftTreeSize = inRootIndex - inStart;
        root.left = buildTree(inStart, inRootIndex - 1, postStart, postStart + leftTreeSize - 1);
        root.right = buildTree(inRootIndex + 1, inEnd, postStart + leftTreeSize, postEnd - 1);
        return root;
    }
}

class Node {
    char val;
    Node left;
    Node right;

    Node(char val) {
        this.val = val;
    }
}
