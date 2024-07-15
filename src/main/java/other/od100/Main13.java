package other.od100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 虚拟游戏理财
 * @since 2024/7/14 18:15
 **/
public class Main13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totalAmount = scanner.nextInt();
        int totalRisk = scanner.nextInt();
        int[] rateOfReturnList = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] riskList = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] maxAmountList = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxReturn = Integer.MIN_VALUE;
        int[][] pairs = new int[2][2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (riskList[i] + riskList[j] > totalRisk) {
                    continue;
                }
                int iAmount;
                int jAmount;
                if (maxAmountList[i] + maxAmountList[j] <= totalAmount) {
                    iAmount = maxAmountList[i];
                    jAmount = maxAmountList[j];
                } else {
                    if (rateOfReturnList[i] >= rateOfReturnList[j]) {
                        iAmount = Math.min(maxAmountList[i], totalAmount);
                        jAmount = totalAmount - iAmount;
                    } else {
                        jAmount = Math.min(maxAmountList[j], totalAmount);
                        iAmount = totalAmount - jAmount;
                    }
                }
                int currentRateOfReturn = iAmount * rateOfReturnList[i] + jAmount * rateOfReturnList[j];
                if (currentRateOfReturn > maxReturn) {
                    maxReturn = currentRateOfReturn;
                    pairs[0][0] = i;
                    pairs[0][1] = iAmount;
                    pairs[1][0] = j;
                    pairs[1][1] = jAmount;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (riskList[i] > totalRisk) {
                continue;
            }
            int iAmount = Math.min(maxAmountList[i], totalAmount);
            int currentRateOfReturn = iAmount * rateOfReturnList[i];
            if (currentRateOfReturn > maxReturn) {
                maxReturn = currentRateOfReturn;
                pairs[0][0] = 0;
                pairs[0][1] = 0;
                pairs[1][0] = i;
                pairs[1][1] = iAmount;
            }
        }
        int[] result = new int[n];
        result[pairs[0][0]] = pairs[0][1];
        result[pairs[1][0]] = pairs[1][1];
        for (int i = 0; i < n; i++) {
            System.out.println(result[i] + " ");
        }

    }
}
