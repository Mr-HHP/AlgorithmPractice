package leetcode;

/**
 * 整数反转
 *
 * @author Mr.黄
 * @date 2022/03/19
 **/
public class Leetcode7 {
    /**
     * 字符串直接反转
     *
     * @param x 给定的整数
     * @return 反转后的整数，如果大小超过int类型的范围则返回0
     */
    public int reverse(int x) {
        String str1 = x + "";
        StringBuilder str = new StringBuilder((x >= 0) ? str1 : str1.substring(1));
        String str2 = ((x >= 0) ? "" : "-") + str.reverse();
        // 判断是否越界
        boolean positiveOverflow = x >= 0 && str2.length() == String.valueOf(Integer.MAX_VALUE).length() && str2.compareTo("2147483647") > 0;
        boolean negativeOverflow = x <= 0 && str2.length() == String.valueOf(Integer.MIN_VALUE).length() && str2.compareTo("-2147483648") > 0;
        if (positiveOverflow || negativeOverflow) {
            // 越界返回0
            return 0;
        }
        return Integer.parseInt(str2);
    }
    
    /**
     * 使用取模法
     *
     * @param x 给定的整数
     * @return 反转后的整数，如果大小超过int类型的范围则返回0
     */
    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println("5".compareTo("2"));
        System.out.println("1".compareTo("2"));
        System.out.println("-5".compareTo("-2"));
        System.out.println("-1".compareTo("-2"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}