package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description CPU算力分配
 * @since 2024/7/14 15:15
 **/
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int l1 = Integer.parseInt(split[0]);
        int l2 = Integer.parseInt(split[1]);
        String[] a = scanner.nextLine().split(" ");
        String[] b = scanner.nextLine().split(" ");
        int sumA = 0;
        int sumB = 0;
        for (String num : a) {
            sumA += Integer.parseInt(num);
        }
        for (String num : b) {
            sumB += Integer.parseInt(num);
        }
        int diff = Math.abs(((sumA + sumB) / 2) - sumA);
        Arrays.sort(a);
        Arrays.sort(b);
        if (sumA > sumB) {
            for (String num : a) {
                if (Arrays.binarySearch(b, String.valueOf(Integer.parseInt(num) - diff)) >= 0) {
                    System.out.println(num + " " + (Integer.parseInt(num) - diff));
                    break;
                }
            }
        } else {
            for (String num : a) {
                if (Arrays.binarySearch(b, String.valueOf(diff + Integer.parseInt(num))) >= 0) {
                    System.out.println(num + " " + (diff + Integer.parseInt(num)));
                    break;
                }
            }
        }
    }
}
