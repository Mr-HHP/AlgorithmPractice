package leetcode;

/**
 * 两数相除
 *
 * @author Mr.黄
 * @date 2022/03/21
 **/
public class Leetcode29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0X80000000 && divisor == -1) {
            // 溢出情况处理
            // 0x80000000为最小的int型整数
            return Integer.MAX_VALUE;
        }
        // 正数转负数，防止溢出
        int negative = 2;
        if (divisor > 0) {
            divisor = -divisor;
            negative--;
        }
        if (dividend > 0) {
            dividend = -dividend;
            negative--;
        }
        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }
    
    /**
     * 使用减法实现两个负数的除法
     * 因为是两个负数进行相除，所有一切判断取反
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    private int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value) {
                // 当除数超过被除数一半时商只能是1
                // 0xc0000000，int型最小整数的一半
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }
}