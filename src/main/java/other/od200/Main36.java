package other.od200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 高效货运
 * @since 2024/7/21 23:01
 **/
public class Main36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wa = array[0];
        int wb = array[1];
        int wt = array[2];
        int pa = array[3];
        int pb = array[4];
        int maxMoney = Integer.MIN_VALUE;
        for (int i = 0; i <= wa; i++) {
            for (int j = 0; j <= wb; j++) {
                int sum = i * wa + j * wb;
                if (sum > wt) {
                    break;
                } else if (sum == wt) {
                    maxMoney = Math.max(maxMoney, pa * i + pb * j);
                }
            }
        }
        System.out.println(maxMoney);
    }
}
