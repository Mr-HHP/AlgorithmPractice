package leetcode;

import java.util.Arrays;

public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    result[i] = Math.min(result[i - coin] + 1, result[i]);
                }
            }
        }
        return result[amount] > amount ? -1 : result[amount];
    }
}
