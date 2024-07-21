package other.od200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 运输时间
 * @since 2024/7/21 22:45
 **/
public class Main35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = ints[0];
        int n = ints[1];
        int[] speeds = new int[m];
        for (int i = 0; i < m; i++) {
            speeds[i] = scanner.nextInt();
        }

        double[] arrivalTimes = new double[m];
        arrivalTimes[0] = (double) n / speeds[0];
        for (int i = 1; i < m; i++) {
            double arrivalTime = (double) n / speeds[i];
            arrivalTimes[i] = Math.max(arrivalTime + i, arrivalTimes[i - 1]);
        }

        System.out.println(arrivalTimes[m - 1] - (m - 1));

    }
}
