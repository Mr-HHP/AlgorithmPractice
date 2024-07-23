package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 计算三叉搜索树的高度
 * @since 2024/7/24 0:08
 **/
public class Main55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Node55 root = new Node55(nums[0]);
        int maxHeight = 1;
        for (int i = 1; i < n; i++) {
            int height = buildTree(root, nums[i]);
            maxHeight = Math.max(maxHeight, height);
        }
        System.out.println(maxHeight + 1);
    }

    public static int buildTree(Node55 root, int num) {
        int height = 1;
        while (true) {
            int diff = num - root.value;
            if (Math.abs(diff) <= 500) {
                if (root.center == null) {
                    root.center = new Node55(num);
                    break;
                } else {
                    root = root.center;
                    height++;
                }
            } else if (diff < -500) {
                if (root.left == null) {
                    root.left = new Node55(num);
                    break;
                } else {
                    root = root.left;
                    height++;
                }
            } else {
                if (root.right == null) {
                    root.right = new Node55(num);
                    break;
                } else {
                    root = root.right;
                    height++;
                }
            }
        }
        return height;
    }
}

class Node55 {
    int value;
    Node55 left;
    Node55 right;
    Node55 center;

    public Node55(int value) {
        this.value = value;
    }
}
