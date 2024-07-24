package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 简易内存池
 * @since 2024/7/25 0:10
 **/
public class Main71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mem = new int[101];
        int[] len = new int[101];
        for (int i = 0; i < n; i++) {
            String[] split = scanner.next().split("=");
            String operation = split[0];
            int val = Integer.parseInt(split[1]);
            if ("REQUEST".equals(operation)) {
                int p = request(mem, len, val);
                if (p == -1) {
                    System.out.println("error");
                } else {
                    System.out.println(p);
                }
            } else if ("RELEASE".equals(operation)) {
                if (!release(mem, len, val)) {
                    System.out.println("error");
                }
            }

        }
    }

    public static boolean release(int[] mem, int[] len, int p) {
        if (len[p] == 0) {
            return false;
        }
        for (int i = 0; i <= p + len[p] - 1; i++) {
            mem[i] = 0;
        }
        len[p] = 0;
        return true;
    }

    public static int request(int[] mem, int[] len, int size) {
        if (size == 0) {
            return -1;
        }
        for (int left = 0; left < 100; left++) {
            if (mem[left] != 0) {
                continue;
            }
            int right = left;
            while (right < 100 && mem[right] == 0) {
                right++;
            }
            if (right - left >= size) {
                for (int i = left; i < left + size; i++) {
                    mem[i] = 1;
                }
                len[left] = size;
                return left;
            }
            left = right;
        }
        return -1;
    }
}
