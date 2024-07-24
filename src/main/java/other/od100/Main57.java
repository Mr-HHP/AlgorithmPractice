package other.od100;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 转盘寿司
 * @since 2024/7/24 14:21
 **/
public class Main57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[prices.length * 2];
        for (int i = 0; i < prices.length * 2; i++) {
            arr[i] = prices[i % prices.length];
        }
        for (int i = 0 ; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < prices[i]) {
                    price += arr[j];
                    break;
                }
            }
            System.out.print(price + " ");
        }
    }

}
