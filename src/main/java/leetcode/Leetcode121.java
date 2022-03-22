package leetcode;

/**
 * 买卖股票的最佳时机
 *
 * @author Mr.黄
 * @date 2022/03/23
 **/
public class Leetcode121 {
    /**
     * 一个循环解题。
     *
     * 只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱
     *
     * @param prices 价格数组
     * @return 最大利润
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    
    /**
     * 双重循环，暴力法
     *
     * @param prices 价格数组
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}