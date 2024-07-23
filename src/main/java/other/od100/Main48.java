package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 找朋友
 * @since 2024/7/23 18:39
 **/
public class Main48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] kids = new int[n];
        for (int i = 0; i < n; i++) {
            kids[i] = scanner.nextInt();
        }
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (kids[j] > kids[i]) {
                    result[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
