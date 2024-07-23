package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 二叉树的计算
 * @since 2024/7/22 22:30
 **/
public class Main43 {
    static int[] inOrder;
    static int[] preOrder;
    static Map<Integer, List<Integer>> inMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inOrder = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        preOrder = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.putIfAbsent(inOrder[i], new ArrayList<>());
            inMap.get(inOrder[i]).add(i);
        }
        Node43 root = buildTree(0, inOrder.length - 1, 0);
        modifyTree(root);
        printInOrder(root);
    }

    public static void printInOrder(Node43 root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public static int modifyTree(Node43 root) {
        if (root == null) {
            return 0;
        }
        int currentValue = root.value;
        int leftValue = modifyTree(root.left);
        int rightValue = modifyTree(root.right);
        root.value = leftValue + rightValue;
        return leftValue + rightValue + currentValue;
    }

    public static Node43 buildTree(int left, int right, int preIndex) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            if (preOrder[preIndex] != inOrder[left]) {
                return null;
            }
        }
        Node43 root = new Node43(preOrder[preIndex]);
        boolean match = false;
        for (int index : inMap.get(preOrder[preIndex])) {
            if (index < left || index > right) {
                continue;
            }
            root.left = buildTree(left, index - 1, preIndex + 1);
            root.right = buildTree(index + 1, right, preIndex + index - left + 1);
            if (left <= index - 1 && root.left == null) {
                continue;
            }
            if (index + 1 <= right && root.right == null) {
                continue;
            }
            match = true;
            break;
        }
        if (!match) {
            return null;
        }
        return root;
    }
}

class Node43 {
    Node43 left;
    Node43 right;
    int value;
    public Node43(int value) {
        this.value = value;
    }
}
