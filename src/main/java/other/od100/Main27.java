package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 最多购买宝石数目
 * @since 2024/7/16 17:20
 **/
public class Main27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = scanner.nextInt();
        }
        int totalMoney = scanner.nextInt();
        int start = 0;
        int pay = 0;
        int end = 0;
        int result = 0;
        for (; end < gems.length; end++) {
            pay += gems[end];
            while (pay > totalMoney) {
                pay -= gems[start];
                start++;
            }
            result = Math.max(end - start + 1, result);
        }
        System.out.println(result);
    }
}
