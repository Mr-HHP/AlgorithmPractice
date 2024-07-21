package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 游戏分组
 * @since 2024/7/21 11:40
 **/
public class Main40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(scores).sum();
        int result = sum;
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                for (int k = j + 1; k < 10; k++) {
                    for (int l = k + 1; l < 10; l++) {
                        for (int m = l + 1; m < 10; m++) {
                            int add = scores[i] + scores[j] + scores[k] + scores[l] + scores[m];
                            result = Math.min(result, Math.abs(sum - add * 2));
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
