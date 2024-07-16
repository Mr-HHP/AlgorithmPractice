package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 小朋友来自多少小区
 * @since 2024/7/16 15:34
 **/
public class Main24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int[] arr = new int[1000];
        for (String s : split) {
            int children = Integer.parseInt(s);
            while (children >= arr.length) {
                arr[arr.length - 1] = 0;
            }
            arr[children]++;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int count = i + 1;
                result += Math.ceil((double) arr[i] / count) * count;
            }
        }
        System.out.println(result);
    }
}
